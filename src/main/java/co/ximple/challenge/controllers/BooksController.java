package co.ximple.challenge.controllers;

import co.ximple.challenge.models.BookRecord;
import co.ximple.challenge.models.LoanRecord;
import co.ximple.challenge.models.RatingRecord;
import co.ximple.challenge.sevices.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/books")
@Tag(name = "books", description = "Endpoints for managing books")
public record BooksController (BooksService service){

    @Operation(summary = "Search books by ID", description = "Get book details by ID")
    @ApiResponse(responseCode = "200", description = "Book details retrieved successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BookRecord.class)))
    @GetMapping("/")
    List<BookRecord> searchBooks(@RequestParam(value = "id_book",required = false) Long id_book){
        return service.searchBooks(id_book);
    }

    @Operation(summary = "Request loan", description = "Request a loan for a book")
    @ApiResponse(responseCode = "200", description = "Loan request successful",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = LoanRecord.class)))
    @PostMapping("/loan")
    LoanRecord requestLoan(@RequestBody LoanRecord loan){
        return service.requestLoan(loan);
    }

    @Operation(summary = "Send review", description = "Send a review for a book")
    @ApiResponse(responseCode = "200", description = "Review sent successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RatingRecord.class)))
    @PostMapping("/reviews")
    RatingRecord sendReview(@RequestBody RatingRecord review){
        return service.sendReview(review);
    }

    @Operation(summary = "List reviews by book ID", description = "Get reviews for a book by its ID")
    @ApiResponse(responseCode = "200", description = "Reviews retrieved successfully",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = RatingRecord.class))))
    @GetMapping("/reviews/{id_book}")
    List<RatingRecord> listReviews(@PathVariable("id_book") String id_book){
        return service.listReviews(id_book);
    }

    @Operation(summary = "Rate book", description = "Rate a book")
    @ApiResponse(responseCode = "200", description = "Book rated successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RatingRecord.class)))
    @PostMapping("/ratings")
    RatingRecord rateBook(@RequestBody RatingRecord rating){
        return service.rateBook(rating);
    }
}
