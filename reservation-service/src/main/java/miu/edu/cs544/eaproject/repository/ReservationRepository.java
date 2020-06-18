package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.service.response.PassengerReservationsResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {
    List<Reservation> findByPassenger_Id(Integer id);

    List<Reservation> findReservationsByCreatedBy(Integer createdBy);
}
