package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void testRecordToEntity_ValidRecord_ReturnUser() {
        // Test data
        UserRecord record = new UserRecord(null, "John", "Doe", "john@example.com");

        // Test
        User user = userMapper.recordToEntity(record);

        // Assertions
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    public void testRecordToEntity_NullRecord_ThrowsException() {
        // Test
        assertThrows(CustomDefaultException.class, () -> userMapper.recordToEntity(null));
    }

}
