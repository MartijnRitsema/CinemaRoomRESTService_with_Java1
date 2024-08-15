package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CinemaController {

    private final List<Seat> seats = new ArrayList<>();

    public CinemaController() {
        int rows = 9;
        int columns = 9;
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
    }

    @GetMapping("/seats")
    public CinemaResponse getSeats() {
        int rows = 9;
        int columns = 9;
        return new CinemaResponse(rows, columns, seats);
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody SeatRequest seatRequest) {
        int row = seatRequest.getRow();
        int column = seatRequest.getColumn();

        // Check if the seat is valid
        if (row < 1 || row > 9 || column < 1 || column > 9) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("The number of a row or a column is out of bounds!"));
        }

        // Find the seat and check if it is already purchased
        for (Seat seat : seats) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                if (seat.isPurchased()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("The ticket has been already purchased!"));
                } else {
                    seat.setPurchased(true);
                    seat.setToken(UUID.randomUUID().toString());
                    return ResponseEntity.ok(new TicketResponse(seat.getToken(), seat));
                }
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("The number of a row or a column is out of bounds!"));
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody TokenRequest token) {
        String tokenString = token.getToken();
        for (Seat seat : seats) {
            if (seat.getToken() != null && seat.getToken().equals(tokenString)) {
                seat.setPurchased(false);
                seat.setToken(null);
                return ResponseEntity.ok(new ReturnResponse(seat));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Wrong token!"));
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(@RequestParam Optional<String> password) {
        if (password.isPresent()) {
            if (!password.get().equals("super_secret")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("The password is wrong!"));
            }
            return ResponseEntity.ok(new StatsResponse(seats));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse("The password is wrong!"));
    }
}