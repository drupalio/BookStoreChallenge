package co.ximple.challenge.mappers;


import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.InventoryRepository;
import co.ximple.challenge.repository.UserRepository;
import co.ximple.challenge.repository.entities.Book;
import co.ximple.challenge.repository.entities.Inventory;
import co.ximple.challenge.repository.entities.Loan;
import co.ximple.challenge.repository.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoanMapper implements Mapper<Loan, LoanRecord> {
    private final BookMapper bookMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    private final InventoryRepository inventoryRepository;

    public LoanMapper(BookMapper bookMapper, UserMapper userMapper, UserRepository userRepository, BooksRepository booksRepository, InventoryRepository inventoryRepository) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Loan recordToEntity(LoanRecord record) {
        if(record==null){
            throw new CustomDefaultException("Loan information doesnt existe, review your payload");
        }
        Loan loan =null;
        Book book= Optional.of(booksRepository.findById(record.book().getId())).get().orElseThrow();
        User user=Optional.of(userRepository.findById(record.user().getId())).get().orElseThrow();
        Inventory inventory=inventoryRepository.findByBookId(book.getId());

            if(record.returnDate()!=null){
                inventory.setAvailablePieces(inventory.getAvailablePieces() + 1);
                inventoryRepository.save(inventory);
                loan=loan = Loan.builder()
                        .user(user)
                        .book(book)
                        .loanDate(record.loanDate())
                        .returnDate(record.returnDate())
                        .build();
            }
            else{
                if (inventory != null && inventory.getAvailable() && inventory.getAvailablePieces() > 0) {
                    inventory.setAvailablePieces(inventory.getAvailablePieces() - 1);
                    inventoryRepository.save(inventory);
                    loan=loan = Loan.builder()
                            .user(user)
                            .book(book)
                            .loanDate(record.loanDate())
                            .build();
                }
                 else {
                        throw new CustomDefaultException("Book not available");
                    }

            }
            return loan;
    }

    @Override
    public LoanRecord entityToRecord(Loan entity) {
       if(entity==null){
           throw new CustomDefaultException("Loan information doesnt existe, review your db");
       }
       return new LoanRecord(Optional.of(entity.getId()),userMapper.entityToRecord(entity.getUser()),bookMapper.entityToRecord(entity.getBook()),entity.getLoanDate(),entity.getReturnDate());
    }
}
