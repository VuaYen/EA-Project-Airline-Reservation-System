package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Passenger;
import miu.edu.cs544.eaproject.service.response.PassengerAndReservationsResponse;
import miu.edu.cs544.eaproject.service.response.PassengerReservationsResponse;

import java.util.List;

public interface PassengerService {
    Passenger getPassengerById(Integer id);

    List<PassengerAndReservationsResponse> getPassengersAndReservationsByReservationsCreatedBy(Integer id);
}
