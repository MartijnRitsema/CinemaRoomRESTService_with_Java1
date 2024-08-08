package cinema;

public class Seat {
    private int row;
    private int column;
    private int price;
    private boolean isBooked = false;

    // Constructor to initialize a seat with row, column, and price
    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        // Set price based on row number
        if (row <= 4) price = 10;
        else price = 8;
    }

    // Getters and setters for row, column, price, and booking status
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
