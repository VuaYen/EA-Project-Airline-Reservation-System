package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    public Reservation createReservation(Reservation reservation);
    public List<Reservation> createListReservation(List<Integer> flightIds, Integer passenger_ID, Integer created_by);
    public Reservation getReservationByCode(String code);
}
