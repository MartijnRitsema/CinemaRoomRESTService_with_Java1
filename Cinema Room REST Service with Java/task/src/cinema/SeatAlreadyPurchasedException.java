package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom exception for already purchased seat
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SeatAlreadyPurchasedException extends RuntimeException {
    public SeatAlreadyPurchasedException(String message) {
        super(message);
    }
}
