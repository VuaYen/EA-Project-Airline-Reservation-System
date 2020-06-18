package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {
    List<Airline> findAirlinesByFlightsDepartureAirportCode(String Code);
}
