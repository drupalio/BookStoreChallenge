package co.ximple.challenge.mappers;

import co.ximple.challenge.models.GenderRecord;
import co.ximple.challenge.repository.entities.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenderMapper {

    @Mapping(target = "id", expression = "java(Optional.empty())")
    Gender recordToEntity(GenderRecord genderRecord);

    GenderRecord entityToRecord(Gender gender);
}
