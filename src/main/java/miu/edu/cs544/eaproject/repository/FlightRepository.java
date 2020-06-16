package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {
    List<Flight> findFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(String departureAirportCode, String arivalAirportCode, Date departureTime);
}
