package miu.edu.cs544.eaproject.service.mapper;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.service.response.FlightResponse;

public class FlightMapper {
    public static FlightResponse mapToFlightResponse(Flight flight) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setId(flight.getId());
        flightResponse.setNumber(flight.getNumber());
        flightResponse.setCapacity(flight.getCapacity());
        flightResponse.setDepartureTime(flight.getDepartureTime());
        flightResponse.setArivalTime(flight.getArivalTime());
        flightResponse.setAirline(AirlineMapper.mapToAirlineResponse(flight.getAirline()));
        flightResponse.setDepartureAirport(AirportMapper.mapToAirportResponse(flight.getDepartureAirport()));
        flightResponse.setArivalAirport(AirportMapper.mapToAirportResponse(flight.getDepartureAirport()));
        return flightResponse;
    }
}
