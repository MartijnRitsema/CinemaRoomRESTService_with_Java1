package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaResponse {
    private int rows;
    private int columns;
    private List<SeatResponse> seats = new ArrayList<>();

    // Constructor to create a response containing cinema details and seat list
    public CinemaResponse(Cinema cinema) {
        this.rows = cinema.getRows();
        this.columns = cinema.getColumns();
        // Add each seat to the response
        for (Seat seat : cinema.getSeats()) {
            seats.add(new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice()));
        }
    }

    // Getters and setters for rows, columns, and seats
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<SeatResponse> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatResponse> seats) {
        this.seats = seats;
    }
}
