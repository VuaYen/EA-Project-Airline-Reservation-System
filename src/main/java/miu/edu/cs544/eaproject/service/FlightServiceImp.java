package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImp implements FlightService{

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight getFlightById(Integer flightId) {
        if(flightRepository.findById(flightId).isPresent())
            return flightRepository.findById(flightId).get();
        return null;
    }
}
