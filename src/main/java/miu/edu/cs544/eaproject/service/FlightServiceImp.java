package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.repository.AirlineRepository;
import miu.edu.cs544.eaproject.repository.AirportRepository;
import miu.edu.cs544.eaproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class FlightServiceImp implements FlightService{
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Flight> viewAllFlights() {
        return toList(flightRepository.findAll());
    }

    @Override
    public List<Airline> viewAllFlightsOutAirport(String airportcode) {
        Airport airport= airportRepository.findByCode(airportcode);
        List<Flight> flights= toList(flightRepository.findAllByDepartureAirport(airport));
        List<Airline> results= new ArrayList<>();
        for (Flight f: flights
             ) {
            results.add(f.getAirline());

        }
        return results;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Flight getFlightById(Integer flightId) {
        if(flightRepository.findById(flightId).isPresent())
            return flightRepository.findById(flightId).get();
        return null;
    }
}
