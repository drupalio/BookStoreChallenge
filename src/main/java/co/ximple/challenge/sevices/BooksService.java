package co.ximple.challenge.sevices;

import co.ximple.challenge.mappers.BookMapper;
import co.ximple.challenge.mappers.RatingMapper;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.BooksRepository;
import co.ximple.challenge.repository.RatingRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final BookMapper bookMapper;
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public BooksService(BooksRepository booksRepository, BookMapper bookMapper, RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.booksRepository = booksRepository;
        this.bookMapper = bookMapper;
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public List<BookRecord> searchBooks(Long id_book) {
        return id_book == null ?
                booksRepository.findAll().stream()
                        .map(book -> bookMapper.entityToRecord(book))
                        .collect(Collectors.toList()) :
                booksRepository.findById(id_book)
                        .map(book -> List.of(bookMapper.entityToRecord(book)))
                        .orElse(List.of());
    }


    public LoanRecord requestLoan(LoanRecord loan) {
        return null;
    }


    public RatingRecord sendReview(RatingRecord review) {
        return null;
    }



    public List<RatingRecord> listReviews(Long id_book) {
        return id_book == null ?
                ratingRepository.findById(id_book).stream()
                        .map(ratingMapper::entityToRecord)
                        .collect(Collectors.toList()) :
                ratingRepository.findAll().stream()
                        .map(ratingMapper::entityToRecord)
                        .collect(Collectors.toList());
    }

    public RatingRecord rateBook(RatingRecord rating) {
        return null;
    }
}
