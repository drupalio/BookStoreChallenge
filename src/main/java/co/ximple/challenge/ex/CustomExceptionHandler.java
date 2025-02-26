package co.ximple.challenge.ex;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomDefaultException.class)
    public ResponseEntity<ErrorResponse> errorResponseNotFoundException(CustomDefaultException notFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), List.of());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
