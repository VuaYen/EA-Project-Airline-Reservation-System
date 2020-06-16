package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Flight;

import java.util.List;

public interface FlightService {
    public List<Flight> viewAllFlights();
    public List<Airline> viewAllFlightsOutAirport(String airportcode);
    public Flight getFlightById(Integer flightId);
}
