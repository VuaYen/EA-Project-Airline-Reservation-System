package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.service.response.AirlineResponse;

import java.util.List;

public interface AirlineService {

    List<AirlineResponse> getAllAirlines();

    AirlineResponse getAirlineById(Integer id);

    AirlineResponse createOrUpdateAirline(Airline airport);

    void deleteAirlineById(Integer id);


    List<AirlineResponse> getAirlinesByFlightsDepartureAirportCode(String code);
}
