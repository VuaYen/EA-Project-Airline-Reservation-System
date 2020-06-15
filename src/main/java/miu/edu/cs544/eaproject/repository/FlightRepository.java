package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight,Integer> {
}
