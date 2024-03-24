package co.ximple.challenge.mappers;

import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.InventoryRepository;
import co.ximple.challenge.repository.UserRepository;
import co.ximple.challenge.repository.entities.Book;
import co.ximple.challenge.repository.entities.Gender;
import co.ximple.challenge.repository.entities.Inventory;
import co.ximple.challenge.repository.entities.Loan;
import co.ximple.challenge.repository.entities.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//TODO FIX
@SpringJUnitConfig
@SpringBootTest
@Disabled
public class LoanMapperTest {

    @Autowired
    private LoanMapper loanMapper;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BooksRepository booksRepository;

    @MockBean
    private InventoryRepository inventoryRepository;

    @Test
    public void testRecordToEntity_ReturnLoan() {
        // Mock data
        LoanRecord record = new LoanRecord(Optional.of(1L),
                new UserRecord(Optional.of(1L), "John", "Doe","john@example.com"),
                new BookRecord(Optional.of(1L), "Book Title", "Author",new GenderRecord(Optional.of(1L),"Gender")),
                new Date(),
                null);  // Ensure the returnDate is null
        User user = new User("John", "Doe","john@example.com");
        Book book = new Book( "Book Title", "Author", new Gender("Gender"));
        Inventory inventory = new Inventory(book, true, 5);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(bookMapper.entityToRecord(book)).thenReturn(new BookRecord(Optional.of(1L), "Book Title", "Author", new GenderRecord(Optional.of(1L),"Gender")));
        when(booksRepository.findById(1L)).thenReturn(Optional.of(book));
        when(inventoryRepository.findByBookId(1L)).thenReturn(inventory); // Match the book ID

        // Test
        Loan loan = loanMapper.recordToEntity(record);

        // Assertions
        assertEquals(user, loan.getUser());
        assertEquals(book, loan.getBook());
    }
}
