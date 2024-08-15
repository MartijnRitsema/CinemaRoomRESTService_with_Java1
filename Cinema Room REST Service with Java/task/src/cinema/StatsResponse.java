package cinema;

import java.util.List;

public class StatsResponse {
    private int income;
    private int available;
    private int purchased;

    public StatsResponse(List<Seat> seats) {
        for (Seat seat : seats) {
            if (seat.isPurchased()) {
                income += seat.getPrice();
                purchased++;
            } else {
                available++;
            }
        }
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }
}