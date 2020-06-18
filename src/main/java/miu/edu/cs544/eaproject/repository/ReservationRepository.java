package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
    List<Reservation> findByPassenger_Id(Integer id);
    List<Reservation> findReservationsByCreatedBy(Integer createdBy);
}
