package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    List<Flight> getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime);
}
