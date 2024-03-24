package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.repository.entities.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GenderMapperTest {

    @InjectMocks
    private GenderMapper genderMapper;

    @Test
    public void testRecordToEntity() {
        GenderRecord record = new GenderRecord(Optional.of(1l),"Fiction");
        Gender gender = genderMapper.recordToEntity(record);
        assertEquals("Fiction", gender.getName());
    }

    @Test
    public void testRecordToEntityWithNullRecord() {
        assertThrows(CustomDefaultException.class, () -> genderMapper.recordToEntity(null));
    }

    @Test
    public void testEntityToRecord() {
        Gender gender = new Gender();
        gender.setId(1L);
        gender.setName("Science");

        GenderRecord record = genderMapper.entityToRecord(gender);
        assertEquals("Science", record.name());
        assertEquals(1L, record.id().orElse(-1L));
    }

    @Test
    public void testEntityToRecordWithNullEntity() {
        assertThrows(CustomDefaultException.class, () -> genderMapper.entityToRecord(null));
    }
}
