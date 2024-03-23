package co.ximple.challenge.controllers;

import co.ximple.challenge.models.Book;
import co.ximple.challenge.models.Loan;
import co.ximple.challenge.models.Rating;
import co.ximple.challenge.models.Review;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/books")
public interface IBooksController {
    @GetMapping("/{id_book}")
    List<Book> searchBooks(@PathVariable("{id_book}") String id_book);

    @PostMapping("/loan")
    Loan requestLoan(@RequestBody Loan loan);

    @PostMapping("/reviews")
    Review sendReview(@RequestBody Review review);

    @GetMapping("/reviews/{id_book}")
    List<Review> listReviews(@PathVariable("{id_book}") String id_book);

    @PostMapping("/ratings")
    Rating rateBook(@RequestBody Rating rating);
}
