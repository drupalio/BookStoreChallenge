package co.ximple.challenge.mappers;

import co.ximple.challenge.ex.CustomDefaultException;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.entities.Rating;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RatingMapper implements Mapper<Rating, RatingRecord> {

    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    public RatingMapper(BookMapper bookMapper, UserMapper userMapper) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Rating recordToEntity(RatingRecord record) {
        if(record==null){
            throw new CustomDefaultException("Rating information empty,review your payload");
        }
        return new Rating(userMapper.recordToEntity(record.user()),bookMapper.recordToEntity(record.book()),record.stars(),record.comment());
    }

    @Override
    public RatingRecord entityToRecord(Rating entity) {
        if(entity==null){
            throw new CustomDefaultException("RatingRecord information empty,review your payload");
        }
        return new RatingRecord(Optional.of(entity.getId()),userMapper.entityToRecord(entity.getUser()),bookMapper.entityToRecord(entity.getBook()),entity.getStars(),entity.getComment());
    }
}