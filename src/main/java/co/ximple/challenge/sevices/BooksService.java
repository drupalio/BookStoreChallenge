package co.ximple.challenge.sevices;

import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.RatingRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Cacheable(value = "cache", key = "'book_id_' + #id_book")
    public List<BookRecord> searchBooks(String id_book) {
        return null;
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
