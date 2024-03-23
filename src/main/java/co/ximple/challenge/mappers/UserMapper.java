package co.ximple.challenge.mappers;


import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper implements Mapper<User, UserRecord> {


    @Override
    public User recordToEntity(UserRecord record) {
        if(record==null){
            throw new CustomDefaultException("No User info, review your payload");
        }
        return new User(record.name(),record.lastName(),record.email());
    }

    @Override
    public UserRecord entityToRecord(User entity) {
        if(entity==null){
            throw new CustomDefaultException("No UserRecord info, review your payload");
        }
        return new UserRecord(Optional.of(entity.getId()),entity.getName(),entity.getLastName(),entity.getEmail());
    }
}