package co.ximple.challenge.mappers;

import co.ximple.challenge.models.UserRecord;
import co.ximple.challenge.repository.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", expression = "java(Optional.empty())")
    User recordToEntity(UserRecord userRecord);

    UserRecord entityToRecord(User user);
}