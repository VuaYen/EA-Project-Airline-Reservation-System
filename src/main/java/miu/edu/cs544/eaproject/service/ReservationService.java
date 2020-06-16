package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getReservationsByPassengerId(Integer id);
}
