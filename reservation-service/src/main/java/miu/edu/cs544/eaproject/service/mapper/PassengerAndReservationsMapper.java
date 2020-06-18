package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Passenger;
import miu.edu.cs544.eaproject.service.response.PassengerAndReservationsResponse;
import miu.edu.cs544.eaproject.service.response.PassengerReservationsResponse;

import java.util.stream.Collectors;

public class PassengerAndReservationsMapper {
    public static PassengerAndReservationsResponse mapToPassengerAndReservationsResponse(Passenger passenger) {
        PassengerAndReservationsResponse newResponse = new PassengerAndReservationsResponse();
        newResponse.setPassengerName(passenger.getName());
        newResponse.setPassengerEmail(passenger.getEmail());
        newResponse.setPassengerPhone(passenger.getPhone());
        newResponse.setPassengerDOB(passenger.getDOB());
        newResponse.setPassengerAddress(passenger.getAddress());
        newResponse.setReservations(passenger.getReservations().stream().map(PassengerReservationsMapper::mapToPassengerReservationsResponse).collect(Collectors.toList()));

        return newResponse;
    }
}
