package co.ximple.challenge.sevices;

import co.ximple.challenge.mappers.BookMapper;
import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.repository.BooksRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final BookMapper bookMapper;

    public BooksService(BooksRepository booksRepository, BookMapper bookMapper) {
        this.booksRepository = booksRepository;
        this.bookMapper = bookMapper;
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


    @Cacheable(value = "cache", key = "'review_id_' + #id_book")
    public List<RatingRecord> listReviews(String id_book) {
        return null;
    }

    public RatingRecord rateBook(RatingRecord rating) {
        return null;
    }
}
