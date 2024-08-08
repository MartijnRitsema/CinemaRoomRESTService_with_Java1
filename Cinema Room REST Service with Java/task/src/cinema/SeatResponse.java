package cinema;

public class SeatResponse {
    private int row;
    private int column;
    private int price;

    // Constructor to create a response for a seat
    public SeatResponse(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    // Getters and setters for row, column, and price
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
