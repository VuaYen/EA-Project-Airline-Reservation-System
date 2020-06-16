package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime) {
        return flightRepository.findFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(departureAirportCode, arivalAirportCode, departureTime);
    }
}
