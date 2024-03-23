package co.ximple.challenge.mappers;

import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.repository.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", expression = "java(Optional.empty())")
    Book recordToEntity(BookRecord bookRecord);

    BookRecord entityToRecord(Book book);
}
