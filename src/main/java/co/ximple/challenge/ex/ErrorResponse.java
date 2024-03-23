package co.ximple.challenge.ex;


import java.util.List;

public record ErrorResponse(String details, List<String> errors) {
}