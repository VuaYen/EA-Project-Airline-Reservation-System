package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.Ticket;
import org.jfree.chart.axis.Tick;

import java.util.List;

public interface TicketService {
    public List<Ticket> viewTickets();
    public Ticket createTicket(Reservation reservation);
    public void removeTicket(String reservationCode);
    public Ticket getTicketByNumber(String number);
}
