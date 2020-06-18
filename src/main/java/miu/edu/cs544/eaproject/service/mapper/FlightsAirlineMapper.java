package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.service.response.FlightsAirlineResponse;

public class FlightsAirlineMapper {
    public static FlightsAirlineResponse mapToFlightsAirlineResponse(Flight flight) {
        FlightsAirlineResponse flightsAirlineResponse = new FlightsAirlineResponse();
        flightsAirlineResponse.setId(flight.getId());
        flightsAirlineResponse.setNumber(flight.getNumber());
        flightsAirlineResponse.setCapacity(flight.getCapacity());
        flightsAirlineResponse.setArivalTime(flight.getArivalTime());
        flightsAirlineResponse.setAirline(AirlineMapper.mapToAirlineResponse(flight.getAirline()));
        return flightsAirlineResponse;
    }
}

