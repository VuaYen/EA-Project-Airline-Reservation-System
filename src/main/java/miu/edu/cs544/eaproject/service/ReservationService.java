package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReservationService {
    public List<Reservation> viewReservations();
    public Reservation createReservation(Reservation reservation);
    public List<Reservation> createListReservation(List<Integer> flightIds, Integer passenger_ID, Integer created_by);
    public Reservation getReservationByCode(String code);
    public List<Ticket> confirmReservation(List<String> flightCodes, Integer passenger_ID);
    public List<Ticket> confirmReservation(List<String> flightCodes);

}
