package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.repository.entities.Book;
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
public class BookMapperTest {

    @Mock
    private GenderMapper genderMapper;

    @InjectMocks
    private BookMapper bookMapper;

    @Test
    public void testRecordToEntity() {
        BookRecord record = new BookRecord(Optional.of(1L), "Title", "Author", null);
        Book book = bookMapper.recordToEntity(record);
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
    }

    @Test
    public void testRecordToEntityWithNullRecord() {
        assertThrows(CustomDefaultException.class, () -> bookMapper.recordToEntity(null));
    }

    @Test
    public void testEntityToRecord() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Title");
        book.setAuthor("Author");
        GenderRecord genderRecord = new GenderRecord(Optional.of(1l),"Gender");

        when(genderMapper.entityToRecord(book.getGender())).thenReturn(genderRecord);

        BookRecord record = bookMapper.entityToRecord(book);
        assertEquals("Title", record.title());
        assertEquals("Author", record.author());
        assertEquals(1L, record.getId());
        assertEquals("Gender", record.gender().name());
    }

    @Test
    public void testEntityToRecordWithNullEntity() {
        assertThrows(CustomDefaultException.class, () -> bookMapper.entityToRecord(null));
    }
}

