package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class FlightServiceImp implements FlightService{
    @Autowired
    private FlightRepository flightRepository;
    @Override
    public List<Flight> viewAllFlights() {
        return toList(flightRepository.findAll());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
