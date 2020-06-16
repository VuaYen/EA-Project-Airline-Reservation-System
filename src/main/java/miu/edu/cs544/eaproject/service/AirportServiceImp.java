package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class AirportServiceImp implements AirportService{
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> viewAirports() {
        return toList(airportRepository.findAll());
    }

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
