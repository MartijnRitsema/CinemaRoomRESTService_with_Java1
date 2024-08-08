package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    // Define an ErrorResponse record
    public record ErrorResponse(String error) {}

    // Handle SeatAlreadyPurchasedException and return a 400 BAD REQUEST response
    @org.springframework.web.bind.annotation.ExceptionHandler(SeatAlreadyPurchasedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePurchaseException(SeatAlreadyPurchasedException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    // Handle SeatNotFoundException and return a 400 BAD REQUEST response
    @org.springframework.web.bind.annotation.ExceptionHandler(SeatNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlePurchaseException(SeatNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
