package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservationsByPassengerId(Integer id) {
        return reservationRepository.findReservationsByPassengerId(id);
    }
}
