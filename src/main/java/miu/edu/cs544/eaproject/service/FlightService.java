package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.service.request.FlightCreateRequest;
import miu.edu.cs544.eaproject.service.response.FlightResponse;

import java.util.Date;
import java.util.List;

public interface FlightService {

    List<FlightResponse> getAllFlights();

    FlightResponse createOrUpdateFlight(FlightCreateRequest flight);

    void deleteFlightById(Integer id);

    List<Airline> viewAllFlightsOutAirport(String airportcode);

    FlightResponse getFlightById(Integer flightId);

    Flight getFlightEntityById(Integer flightId);

    List<FlightResponse> getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime);
}
