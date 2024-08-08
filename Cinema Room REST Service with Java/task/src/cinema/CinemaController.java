package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CinemaController {
    final Cinema cinema;
    private final Map<String, Seat> tokenSeatMap = new HashMap<>();

    // Constructor to inject Cinema bean
    public CinemaController(Cinema cinema) {
        this.cinema = cinema;
    }

    // Endpoint to get the list of seats in the cinema
    @GetMapping("/seats")
    public CinemaResponse getCinemaResponse() {
        return new CinemaResponse(cinema);
    }

    // Endpoint to purchase a ticket for a specific seat
    @PostMapping("/purchase")
    public ResponseEntity<Map<String, Object>> checkAndPurchaseTicket(@RequestBody SeatRequest seatRequest) {
        // Check each seat in the cinema
        for (Seat seat : cinema.getSeats()) {
            // If seat matches the request
            if (seat.getRow() == seatRequest.getRow() && seat.getColumn() == seatRequest.getColumn()) {
                // If the seat is not booked, book it and return the seat details
                if (!seat.isBooked()) {
                    seat.setBooked(true);
                    String token = UUID.randomUUID().toString();
                    tokenSeatMap.put(token, seat);
                    Map<String, Object> response = new HashMap<>();
                    response.put("token", token);
                    response.put("ticket", new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                // Throw an exception if the seat is already booked
                throw new SeatAlreadyPurchasedException("The ticket has been already purchased!");
            }
        }
        // Throw an exception if the seat is not found
        throw new SeatNotFoundException("The number of a row or a column is out of bounds!");
    }

    // Endpoint to return a purchased ticket
    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, String> tokenRequest) {
        String token = tokenRequest.get("token");
        Seat seat = tokenSeatMap.remove(token);

        // If the token is invalid or the seat is not found, return an error response
        if (seat == null) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Wrong token!");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // Mark the seat as available again and return the seat details
        seat.setBooked(false);
        Map<String, Object> response = new HashMap<>();
        response.put("ticket", new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
