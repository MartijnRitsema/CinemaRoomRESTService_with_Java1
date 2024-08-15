package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Seat {
    private int row;
    private int column;
    private int price;

    @JsonIgnore
    private boolean purchased = false;

    @JsonIgnore
    private String token;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}