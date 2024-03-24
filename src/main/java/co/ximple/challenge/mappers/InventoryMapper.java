package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.InventoryRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.entities.Book;
import co.ximple.challenge.repository.entities.Inventory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryMapper implements Mapper<Inventory, InventoryRecord> {

    private final BookMapper bookMapper;
    private final BooksRepository booksRepository;

    public InventoryMapper(BookMapper bookMapper, BooksRepository booksRepository) {
        this.bookMapper = bookMapper;
        this.booksRepository = booksRepository;
    }


    @Override
    public Inventory recordToEntity(InventoryRecord record) {
        if(record==null){
            throw new CustomDefaultException("No inventory data, review your payload");
        }
        Book book= Optional.of(booksRepository.findById(record.book().getId())).get().orElseThrow();
        return new Inventory(book,record.available(),record.availablePieces());
    }

    @Override
    public InventoryRecord entityToRecord(Inventory entity) {
        if(entity==null){
            throw new CustomDefaultException("No inventory entity, review your db");
        }
        return new InventoryRecord(Optional.of(entity.getId()),bookMapper.entityToRecord(entity.getBook()),entity.getAvailable(),entity.getAvailablePieces());
    }
}