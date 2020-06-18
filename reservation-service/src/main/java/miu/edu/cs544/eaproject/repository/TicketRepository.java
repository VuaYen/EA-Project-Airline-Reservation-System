package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Ticket;
import org.jfree.chart.axis.Tick;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer> {
    Ticket findByNumber(String number);
    Ticket findByReservationCode(String code);
}
