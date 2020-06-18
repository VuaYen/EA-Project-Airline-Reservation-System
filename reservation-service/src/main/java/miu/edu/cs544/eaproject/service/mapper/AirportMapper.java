package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.service.response.AirportResponse;

public class AirportMapper {
    public static AirportResponse mapToAirportResponse(Airport airport) {
        AirportResponse airportResponse = new AirportResponse();

        airportResponse.setId(airport.getId());
        airportResponse.setCode(airport.getCode());
        airportResponse.setName(airport.getName());
        airportResponse.setAddress(airport.getAddress());
        return airportResponse;
    }
}
