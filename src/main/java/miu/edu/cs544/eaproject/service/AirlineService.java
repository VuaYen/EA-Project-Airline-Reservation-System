package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> getAirlinesByFlightsDepartureAirportCode(String code);
}
