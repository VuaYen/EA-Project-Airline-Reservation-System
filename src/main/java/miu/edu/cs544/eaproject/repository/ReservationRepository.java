package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,String> {
}
