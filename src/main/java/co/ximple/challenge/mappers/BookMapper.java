package co.ximple.challenge.mappers;


import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.repository.entities.Book;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMapper implements Mapper<Book,BookRecord>{

    private GenderMapper genderMapper;
    public BookMapper(GenderMapper genderMapper){
        this.genderMapper=genderMapper;
    }
    @Override
    public Book recordToEntity(BookRecord record) {
        if(record==null){
            throw new CustomDefaultException("No book data, review your payload");
        }
        Book book=new Book();
        book.setTitle(record.title());
        book.setAuthor(record.author());
        return book;
    }

    @Override
    public BookRecord entityToRecord(Book entity) {
        if(entity==null){
            throw new CustomDefaultException("No book data on the database, review your payload");
        }
        return new BookRecord(Optional.of(entity.getId()),entity.getTitle(),entity.getAuthor(),genderMapper.entityToRecord(entity.getGender()));
    }
}