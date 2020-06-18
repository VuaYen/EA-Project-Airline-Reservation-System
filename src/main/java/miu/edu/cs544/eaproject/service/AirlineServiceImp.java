package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class AirlineServiceImp implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;


    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Airline> getAllAirlines() {
        List<Airline> airlineList = (List<Airline>) airlineRepository.findAll();

        if (airlineList.size() > 0) {
            return airlineList;
        } else {
            return new ArrayList<Airline>();
        }

    }

    @Override
    public Airline getAirlineById(Integer id) throws RecordNotFoundException {
        Optional<Airline> airline = airlineRepository.findById(id);

        if (airline.isPresent()) {
            return airline.get();
        } else {
            throw new RecordNotFoundException("No airline record exist for given id");
        }
    }

    @Override
    public Airline createOrUpdateAirline(Airline entity) throws RecordNotFoundException {
        Optional<Airline> airline = airlineRepository.findById(entity.getId());

        if (airline.isPresent()) {
            Airline newEntity = airline.get();

            newEntity.setCode(entity.getCode());
            newEntity.setName(entity.getName());
            newEntity.setHistory(entity.getHistory());
            newEntity.setFlights(entity.getFlights());

            newEntity = airlineRepository.save(newEntity);
            return newEntity;
        } else {
            entity = airlineRepository.save(entity);
            return entity;
        }
    }

    @Override
    public void deleteAirlineById(Integer id) throws RecordNotFoundException {
        Optional<Airline> airline = airlineRepository.findById(id);

        if (airline.isPresent()) {
            airlineRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No airline record exist for given id");
        }
    }

    @Override
    public List<Airline> getAirlinesByFlightsDepartureAirportCode(String code) {
        return airlineRepository.findAirlinesByFlightsDepartureAirportCode(code);
    }
}
