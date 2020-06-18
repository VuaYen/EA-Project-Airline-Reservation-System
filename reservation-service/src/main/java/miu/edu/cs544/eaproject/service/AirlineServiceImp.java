package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.repository.AirlineRepository;
import miu.edu.cs544.eaproject.service.mapper.AirlineMapper;
import miu.edu.cs544.eaproject.service.response.AirlineResponse;
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
    public List<AirlineResponse> getAllAirlines() {
        List<Airline> airlineList = (List<Airline>) airlineRepository.findAll();

        if (airlineList.size() > 0) {
            return airlineList.stream().map(AirlineMapper::mapToAirlineResponse).collect(Collectors.toList());
        } else {
            return new ArrayList<Airline>().stream().map(AirlineMapper::mapToAirlineResponse).collect(Collectors.toList());
        }

    }

    @Override
    public AirlineResponse getAirlineById(Integer id) throws RecordNotFoundException {
        Optional<Airline> airline = airlineRepository.findById(id);

        if (airline.isPresent()) {
            return AirlineMapper.mapToAirlineResponse(airline.get());
        } else {
            throw new RecordNotFoundException("No airline record exist for given id");
        }
    }

    @Override
    public AirlineResponse createOrUpdateAirline(Airline entity) throws RecordNotFoundException {
        Optional<Airline> airline = airlineRepository.findById(entity.getId());

        if (airline.isPresent()) {
            Airline newEntity = airline.get();

            newEntity.setCode(entity.getCode());
            newEntity.setName(entity.getName());
            newEntity.setHistory(entity.getHistory());
            newEntity.setFlights(entity.getFlights());

            newEntity = airlineRepository.save(newEntity);
            return AirlineMapper.mapToAirlineResponse(newEntity);
        } else {
            entity = airlineRepository.save(entity);
            return AirlineMapper.mapToAirlineResponse(entity);
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
    public List<AirlineResponse> getAirlinesByFlightsDepartureAirportCode(String code) {
        return airlineRepository.findAirlinesByFlightsDepartureAirportCode(code).stream().map(AirlineMapper::mapToAirlineResponse).collect(Collectors.toList());
    }
}
