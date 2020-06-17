package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.Ticket;
import miu.edu.cs544.eaproject.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class TicketServiceImp implements TicketService {

    private static final Integer TICKET_NUMBER_LENGTH = 20;
    private static final String TICKET_NUMBER_STRING = "0123456789";

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> viewTickets() {
        return toList(ticketRepository.findAll());
    }

    @Override
    public Ticket createTicket(Reservation reservation) {
        Ticket ticket = new Ticket();

        ticket.setFlight(reservation.getFlight());
        ticket.setFlightdate(reservation.getFlight().getDepartureTime());
        ticket.setNumber(this.generateTicketNumber());
        ticket.setPassengerID(reservation.getPassengerID());
        ticket.setReservation(reservation);

        this.ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public void removeTicket(String reservationCode) {
        Ticket ticket = this.ticketRepository.findByReservationCode(reservationCode);
        this.ticketRepository.delete(ticket);
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Ticket getTicketByNumber(String number) {
        return this.ticketRepository.findByNumber(number);
    }

    private String generateTicketNumber() {
        String AB = TICKET_NUMBER_STRING;
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( TICKET_NUMBER_LENGTH );
        for( int i = 0; i < TICKET_NUMBER_LENGTH; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );

        String number = sb.toString();

        if(this.getTicketByNumber(number) != null)
            this.generateTicketNumber();

        return number;
    }
}
