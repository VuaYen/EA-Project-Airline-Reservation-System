package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;

import java.util.List;

public interface AirlineService {

    List<Airline> getAllAirlines();

    Airline getAirlineById(Integer id);

    Airline createOrUpdateAirline(Airline airport);

    void deleteAirlineById(Integer id);


    List<Airline> getAirlinesByFlightsDepartureAirportCode(String code);
}
