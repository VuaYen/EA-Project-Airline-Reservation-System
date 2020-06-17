package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.ReservationStatus;
import miu.edu.cs544.eaproject.domain.Ticket;
import miu.edu.cs544.eaproject.exception.NotAcceptableException;
import miu.edu.cs544.eaproject.repository.ReservationRepository;
import miu.edu.cs544.eaproject.service.request.AgentReservationCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService {

    private static final Integer RESERVATION_CODE_LENGTH = 6;
    private static final String RESERVATION_CODE_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @Override
    public List<Reservation> createListReservation(List<Integer> flightIds, Integer passenger_ID, Integer created_by) {

        List<Reservation> reservations = new ArrayList<>();

        for (int flightId : flightIds) {
            reservations.add(this.createReservation(flightId, passenger_ID, created_by));
        }

        return reservations;
    }

    @Override
    public List<Reservation> createListReservationByAgent(List<AgentReservationCreateRequest> agentReservationRequests, Integer created_by) {
        List<Reservation> reservations = new ArrayList<>();

        for (AgentReservationCreateRequest agentReservationRequest : agentReservationRequests) {
            reservations.add(this.createReservation(agentReservationRequest.getFlightId(), agentReservationRequest.getPassengerId(), created_by));
        }

        return reservations;
    }

    @Override
    public Reservation createReservation(Integer flightId, Integer passenger_ID, Integer created_by) {
        Reservation reservation = null;
        Flight flight = flightService.getFlightById(flightId);
        if(flight != null) {
            reservation = new Reservation();
            String code = this.generateReservationCode();

            reservation.setCode(code);
            reservation.setStatus(ReservationStatus.New);
            reservation.setFlight(flight);
            reservation.setCreatedBy(created_by);
            reservation.setPassengerID(passenger_ID);
            reservation.setCreatedDate(new Date());

            this.reservationRepository.save(reservation);
        } else {
            throw new NotAcceptableException("Flight id " + flightId + " does not found!" );
        }

        return reservation;
    }

    @Override
    public Reservation getReservationByCode(String code) {
        if(this.reservationRepository.findById(code).isPresent())
            return this.reservationRepository.findById(code).get();
        return null;
    }

    @Override
    public List<Ticket> confirmReservation(List<String> reservationCodes, Integer current_user_ID) {
        List<Ticket> tickets = new ArrayList<>();
        for ( String reservationCode: reservationCodes) {
            Reservation reservation = this.getReservationByCode(reservationCode);
            if(reservation != null) {
                if(!reservation.getCreatedBy().equals(current_user_ID)) {
                    throw new NotAcceptableException("Reservation code " + reservationCode + " does not match with you!" );
                }

                if(!reservation.getStatus().equals(ReservationStatus.New)) {
                    throw new NotAcceptableException("Reservation code " + reservationCode + " is confirmed!" );
                }

                tickets.add(this.ticketService.createTicket(reservation));
                reservation.setStatus(ReservationStatus.Accept);
            }
            else {
                throw new NotAcceptableException("Reservation code " + reservationCode + " does not found!" );
            }
        }

        return tickets;
    }

    public boolean cancelReservations(String reservationCode, Integer current_user_ID) {
        Reservation reservation = this.getReservationByCode(reservationCode);

        if(reservation != null) {
            if(!reservation.getCreatedBy().equals(current_user_ID)) {
                throw new NotAcceptableException("Reservation code " + reservationCode + " does not match with you!" );
            }

            if(reservation.getStatus().equals(ReservationStatus.Cancel)) {
                throw new NotAcceptableException("Reservation code " + reservationCode + " is canceled!" );
            }
            this.ticketService.removeTicket(reservationCode);
            reservation.setStatus(ReservationStatus.Cancel);
            this.reservationRepository.save(reservation);
            return true;
        }
        else {
            throw new NotAcceptableException("Reservation code " + reservationCode + " does not found!" );
        }
    }

    private String generateReservationCode() {
        String AB = RESERVATION_CODE_STRING;
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder( RESERVATION_CODE_LENGTH );
        for( int i = 0; i < RESERVATION_CODE_LENGTH; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );

        String code = sb.toString();

        if(this.getReservationByCode(code) != null)
            this.generateReservationCode();

        return code;
    }

    @Override
    public List<Reservation> viewReservations() {
        return toList(reservationRepository.findAll());
    }
    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> getReservationsByPassengerId(Integer id) {
        return reservationRepository.findReservationsByPassengerID(id);
    }
}
