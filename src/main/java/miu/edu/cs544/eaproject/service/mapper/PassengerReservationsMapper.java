package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.service.response.PassengerReservationsResponse;

public class PassengerReservationsMapper {
    public static PassengerReservationsResponse mapToPassengerReservationsResponse(Reservation reservation) {
        PassengerReservationsResponse passengerReservationsResponse = new PassengerReservationsResponse();
        passengerReservationsResponse.setCode(reservation.getCode());
        passengerReservationsResponse.setCreatedBy(reservation.getCreatedBy());
        passengerReservationsResponse.setCreatedDate(reservation.getCreatedDate());
        passengerReservationsResponse.setStatus(reservation.getStatus());
        passengerReservationsResponse.setFlightNumber(reservation.getFlight().getNumber());
        passengerReservationsResponse.setFlightDepartureTime(reservation.getFlight().getDepartureTime());
        passengerReservationsResponse.setFlightArivalTime(reservation.getFlight().getArivalTime());
        passengerReservationsResponse.setFlightDepartureAirportCode(reservation.getFlight().getDepartureAirport().getCode());
        passengerReservationsResponse.setFlightArivalAirportCode(reservation.getFlight().getArivalAirport().getCode());
        passengerReservationsResponse.setPassengerName(reservation.getPassenger().getName());

        return passengerReservationsResponse;
    }
}
