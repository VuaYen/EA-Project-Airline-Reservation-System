package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirlineRepository extends CrudRepository<Airline,Integer> {
//    public Airline getByFlight(Flight fly);
//    public List<Airline> getAirlinesByFlights(List<Flight> flights);
}
