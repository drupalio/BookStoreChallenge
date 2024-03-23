package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.repository.entities.Gender;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class GenderMapper implements Mapper<Gender,GenderRecord>{

    @Override
    public Gender recordToEntity(GenderRecord record) {
        if(record==null){
            throw new CustomDefaultException("No gender data, review your payload");
        }
        Gender gender =new Gender();
        gender.setName(record.name());
        return gender;
    }

    @Override
    public GenderRecord entityToRecord(Gender entity) {
        if(entity==null){
            throw new CustomDefaultException("No book data on the database, review your payload");
        }
        return new GenderRecord(Optional.of(entity.getId()),entity.getName());
    }
}