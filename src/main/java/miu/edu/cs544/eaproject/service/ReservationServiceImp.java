package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public List<Reservation> viewReservations() {
        return toList(reservationRepository.findAll());
    }
    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
