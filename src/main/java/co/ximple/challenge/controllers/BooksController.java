package co.ximple.challenge.controllers;

import co.ximple.challenge.models.Book;
import co.ximple.challenge.models.Loan;
import co.ximple.challenge.models.Rating;
import co.ximple.challenge.models.Review;

import java.util.List;

public class BooksController implements IBooksController{
    @Override
    public List<Book> searchBooks(String id_book) {
        return null;
    }

    @Override
    public Loan requestLoan(Loan loan) {
        return null;
    }

    @Override
    public Review sendReview(Review review) {
        return null;
    }

    @Override
    public List<Review> listReviews(String id_book) {
        return null;
    }

    @Override
    public Rating rateBook(Rating rating) {
        return null;
    }
}
