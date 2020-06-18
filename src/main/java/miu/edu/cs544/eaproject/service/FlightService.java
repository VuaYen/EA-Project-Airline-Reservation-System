package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.service.request.FlightCreateRequest;

import java.util.Date;
import java.util.List;

public interface FlightService {

    List<Flight> getAllFlights();

    Flight createOrUpdateFlight(FlightCreateRequest flight);

    void deleteFlightById(Integer id);

    List<Airline> viewAllFlightsOutAirport(String airportcode);

    Flight getFlightById(Integer flightId);

    List<Flight> getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime);
}
