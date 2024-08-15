package cinema;

public class ReturnResponse {
    private Seat ticket;

    public ReturnResponse(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}