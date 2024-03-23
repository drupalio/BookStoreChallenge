package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.entities.Book;
import co.ximple.challenge.repository.entities.Rating;
import co.ximple.challenge.repository.entities.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RatingMapper implements Mapper<Rating, RatingRecord> {

    private final BookMapper bookMapper;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    public RatingMapper(BookMapper bookMapper, UserMapper userMapper, UserRepository userRepository, BooksRepository booksRepository) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }


    @Override
    public Rating recordToEntity(RatingRecord record) {
        if (record == null) {
            throw new CustomDefaultException("Rating information is empty. Review your payload.");
        }
        Book book=Optional.of(booksRepository.findById(record.book().getId())).get().orElseThrow();
        User user=Optional.of(userRepository.findById(record.user().getId())).get().orElseThrow();
        return new Rating(user, book, record.stars(), record.comment());
    }

    @Override
    public RatingRecord entityToRecord(Rating entity) {
        if (entity == null) {
            throw new CustomDefaultException("RatingRecord information is empty. Review your payload.");
        }
        return new RatingRecord(Optional.ofNullable(entity.getId()), null, null, entity.getStars(), entity.getComment());
    }
}
