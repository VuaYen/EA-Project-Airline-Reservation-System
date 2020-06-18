package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.repository.AirportRepository;
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
public class AirportServiceImp implements AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAllAirports() {
        List<Airport> airportList = (List<Airport>) airportRepository.findAll();

        if (airportList.size() > 0) {
            return airportList;
        } else {
            return new ArrayList<Airport>();
        }
    }

    @Override
    public Airport getAirportById(Integer id) throws RecordNotFoundException {
        Optional<Airport> airport = airportRepository.findById(id);

        if (airport.isPresent()) {
            return airport.get();
        } else {
            throw new RecordNotFoundException("No airport record exist for given id");
        }
    }

    @Override
    public Airport createOrUpdateAirport(Airport entity) throws RecordNotFoundException {
        Optional<Airport> airport = airportRepository.findById(entity.getId());

        if (airport.isPresent()) {
            Airport newEntity = airport.get();

            newEntity.setCode(entity.getCode());
            newEntity.setName(entity.getName());
            newEntity.setAddress(entity.getAddress());

            newEntity = airportRepository.save(newEntity);
            return newEntity;
        } else {
            entity = airportRepository.save(entity);
            return entity;
        }
    }

    @Override
    public void deleteAirportById(Integer id) throws RecordNotFoundException {
        Optional<Airport> airport = airportRepository.findById(id);

        if (airport.isPresent()) {
            airportRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No airport record exist for given id");
        }
    }

}
