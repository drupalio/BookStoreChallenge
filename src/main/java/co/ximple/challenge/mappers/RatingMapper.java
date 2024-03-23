package co.ximple.challenge.mappers;


import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.entities.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    @Mapping(target = "id", expression = "java(Optional.empty())")
    Rating recordToEntity(RatingRecord ratingRecord);

    RatingRecord entityToRecord(Rating rating);
}