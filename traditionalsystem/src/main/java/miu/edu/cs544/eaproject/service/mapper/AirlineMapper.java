package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.service.response.AirlineResponse;
import miu.edu.cs544.eaproject.service.response.FlightResponse;

import java.util.stream.Collectors;

public class AirlineMapper {
    public static AirlineResponse mapToAirlineResponse(Airline airline) {
        AirlineResponse airlineResponse = new AirlineResponse();

        airlineResponse.setId(airline.getId());
        airlineResponse.setCode(airline.getCode());
        airlineResponse.setName(airline.getName());
        airlineResponse.setHistory(airline.getHistory());
        return airlineResponse;
    }
}
