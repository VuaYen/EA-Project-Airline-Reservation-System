package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline,Integer> {
}
