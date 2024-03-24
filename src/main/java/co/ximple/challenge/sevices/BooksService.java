package co.ximple.challenge.sevices;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.mappers.BookMapper;
import co.ximple.challenge.mappers.InventoryMapper;
import co.ximple.challenge.mappers.LoanMapper;
import co.ximple.challenge.mappers.RatingMapper;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.InventoryRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.InventoryRepository;
import co.ximple.challenge.repository.LoanRepository;
import co.ximple.challenge.repository.RatingRepository;
import co.ximple.challenge.repository.entities.Loan;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final BookMapper bookMapper;
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    private final LoanMapper loanMapper;
    private final LoanRepository loanRepository;

    private final InventoryMapper inventoryMapper;
    private final InventoryRepository inventoryRepository;

    public BooksService(BooksRepository booksRepository, BookMapper bookMapper, RatingRepository ratingRepository, RatingMapper ratingMapper, LoanMapper loanMapper, LoanRepository loanRepository, InventoryMapper inventoryMapper, InventoryRepository inventoryRepository) {
        this.booksRepository = booksRepository;
        this.bookMapper = bookMapper;
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
        this.loanMapper = loanMapper;
        this.loanRepository = loanRepository;
        this.inventoryMapper = inventoryMapper;
        this.inventoryRepository = inventoryRepository;
    }

    public List<BookRecord> searchBooks(Long id_book) {
        return id_book == null ?
                booksRepository.findAll().stream()
                        .map(book -> bookMapper.entityToRecord(book))
                        .collect(Collectors.toList()) :
                booksRepository.findById(id_book)
                        .map(book -> List.of(bookMapper.entityToRecord(book)))
                        .orElse(List.of());
    }


    public LoanRecord requestLoan(LoanRecord loan) {
        return loanMapper.entityToRecord(loanRepository.save(loanMapper.recordToEntity(loan)));
    }

    public List<RatingRecord> listReviews(Long id_book) {
        return id_book == null ?
                ratingRepository.findById(id_book).stream()
                        .map(ratingMapper::entityToRecord)
                        .collect(Collectors.toList()) :
                ratingRepository.findAll().stream()
                        .map(ratingMapper::entityToRecord)
                        .collect(Collectors.toList());
    }

    public RatingRecord rateBook(RatingRecord rating) {
        return  ratingMapper.entityToRecord(ratingRepository.save(ratingMapper.recordToEntity(rating)));
    }


    public LoanRecord returnBook(Long idLoan) {
        Loan loan = loanRepository.findById(idLoan)
                .orElseThrow(() -> new CustomDefaultException("Loan doesn't exist"));

        loan.setReturnDate(new Date());

        return loanMapper.entityToRecord(loanRepository.save(loanMapper.recordToEntity(loanMapper.entityToRecord(loan))));
    }

    public List<LoanRecord> listLoans(Long idUser) {
        return loanRepository.findAllByUserId(idUser).stream().map(loanMapper::entityToRecord).collect(Collectors.toList());
    }

    public InventoryRecord inventory(Long idBook) {
        return inventoryMapper.entityToRecord(inventoryRepository.findByBookId(idBook));
    }
}
