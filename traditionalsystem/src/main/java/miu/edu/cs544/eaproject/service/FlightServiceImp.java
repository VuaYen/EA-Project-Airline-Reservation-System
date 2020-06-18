package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.repository.AirlineRepository;
import miu.edu.cs544.eaproject.repository.AirportRepository;
import miu.edu.cs544.eaproject.repository.FlightRepository;
import miu.edu.cs544.eaproject.service.mapper.FlightMapper;
import miu.edu.cs544.eaproject.service.request.FlightCreateRequest;
import miu.edu.cs544.eaproject.service.response.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<FlightResponse> getAllFlights() {
        List<Flight> flightList = (List<Flight>) flightRepository.findAll();

        if (flightList.size() > 0) {
            return flightList.stream().map(FlightMapper::mapToFlightResponse).collect(Collectors.toList());
        } else {
            return new ArrayList<Flight>().stream().map(FlightMapper::mapToFlightResponse).collect(Collectors.toList());
        }
    }

    @Override
    public FlightResponse createOrUpdateFlight(FlightCreateRequest entity) throws RecordNotFoundException {
        Optional<Flight> flight = flightRepository.findById(entity.getId());
        Flight newEntity;
        if (flight.isPresent()) {
            newEntity = flight.get();
        } else {
            newEntity = new Flight();
        }
        newEntity.setNumber(entity.getNumber());
        newEntity.setCapacity(entity.getCapacity());
        newEntity.setDepartureTime(entity.getDepartureTime());
        newEntity.setArivalTime(entity.getArivalTime());
        newEntity.setAirline(airlineRepository.findById(entity.getAirlineId()).get());
        newEntity.setDepartureAirport(airportRepository.findById(entity.getDepartureAirportId()).get());
        Integer fff = entity.getArivalAirportId();
        newEntity.setArivalAirport(airportRepository.findById(fff).get());

        newEntity = flightRepository.save(newEntity);
        return FlightMapper.mapToFlightResponse(newEntity);
    }

    @Override
    public void deleteFlightById(Integer id) throws RecordNotFoundException {
        Optional<Flight> flight = flightRepository.findById(id);

        if (flight.isPresent()) {
            flightRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No flight record exist for given id");
        }
    }

    @Override
    public List<Airline> viewAllFlightsOutAirport(String airportcode) {
        Airport airport = airportRepository.findByCode(airportcode);

        List<Flight> flights = toList(flightRepository.findAllByDepartureAirport(airport));
        List<Airline> results = new ArrayList<>();
        for (Flight f : flights) {
            results.add(f.getAirline());
        }
        return results;
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public FlightResponse getFlightById(Integer flightId) {
        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            return FlightMapper.mapToFlightResponse(flight.get());
        } else {
            throw new RecordNotFoundException("No flight record exist for given id");
        }
    }

    @Override
    public List<FlightResponse> getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime) {
        return flightRepository.findFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(departureAirportCode, arivalAirportCode, departureTime).stream().map(FlightMapper::mapToFlightResponse).collect(Collectors.toList());
    }
}
