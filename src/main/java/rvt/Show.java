package rvt;

import java.util.ArrayList;
import java.util.List;

public class Show {

    private String movie;
    private String time;
    private List<Ticket> tickets;

    public Show(String movie, String time) {
        this.movie = movie;
        this.time = time;
        this.tickets = new ArrayList<>();
    }

    public String getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }
    
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}