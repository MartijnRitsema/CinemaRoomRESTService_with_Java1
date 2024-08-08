package cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int rows;
    private int columns;
    private List<Seat> seats = new ArrayList<>();

    // Constructor to initialize Cinema with a specified number of rows and columns
    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        // Initialize seats for each row and column
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
    }

    // Getters and setters for rows and columns
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

    // Getter for seats
    public List<Seat> getSeats() {
        return seats;
    }

    // Setter for seats
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
