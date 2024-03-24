package co.ximple.challenge.mappers;
import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.models.InventoryRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.entities.Book;
import co.ximple.challenge.repository.entities.Gender;
import co.ximple.challenge.repository.entities.Inventory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventoryMapperTest {

    @Mock
    private BookMapper bookMapper;

    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private InventoryMapper inventoryMapper;

    @Test
    public void testRecordToEntity() {
        InventoryRecord record = new InventoryRecord(Optional.of(1L), new BookRecord(Optional.of(1l), "Title", "Author",new GenderRecord(Optional.of(1l),"Gender")), true, 5);
        Gender gender = new Gender("Gender");
        Book book = new Book("Title", "Author", gender);
        when(booksRepository.findById(1L)).thenReturn(Optional.of(book));

        Inventory inventory = inventoryMapper.recordToEntity(record);
        assertEquals(record.available(), inventory.getAvailable());
        assertEquals(record.availablePieces(), inventory.getAvailablePieces());
    }

    @Test
    public void testRecordToEntityWithNullRecord() {
        assertThrows(CustomDefaultException.class, () -> inventoryMapper.recordToEntity(null));
    }




}
