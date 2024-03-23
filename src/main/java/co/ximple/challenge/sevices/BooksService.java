package co.ximple.challenge.sevices;

import co.ximple.challenge.models.Book;
import co.ximple.challenge.models.Loan;
import co.ximple.challenge.models.Rating;
import co.ximple.challenge.models.Review;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Cacheable(value = "cache", key = "'book_id_' + #id_book")
    public List<Book> searchBooks(String id_book) {
        return null;
    }


    public Loan requestLoan(Loan loan) {
        return null;
    }


    public Review sendReview(Review review) {
        return null;
    }


    @Cacheable(value = "cache", key = "'review_id_' + #id_book")
    public List<Review> listReviews(String id_book) {
        return null;
    }

    public Rating rateBook(Rating rating) {
        return null;
    }
}
