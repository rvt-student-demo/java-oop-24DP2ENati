package rvt;

public class Ticket {

    private int seat;
    private int code;
    private Show show;

    public Ticket(int seat, int code, Show show) {
        this.seat = seat;
        this.code = code;
        this.show = show;
        show.addTicket(this);
    }

    public int getSeat() {
        return seat;
    }

    public int getCode() {
        return code;
    }

    public Show getShow() {
        return show;
    }
}