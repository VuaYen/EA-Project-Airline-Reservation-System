package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Integer> {
}
