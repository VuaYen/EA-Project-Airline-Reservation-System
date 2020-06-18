package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Account;
import miu.edu.cs544.eaproject.domain.Airline;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class AirlineRepositoryTest {
    @Autowired
    private  AirlineRepository airlineRepository;

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Test
    public void findAirlineByID() throws Exception{
        Airline airline = airlineRepository.findById(1).get();
        assertEquals("American Airlines", airline.getName());
    }
    @Test
    public void countAirlines() throws Exception{
        List<Airline> airlines = toList(airlineRepository.findAll());
        assertEquals(37,airlines.size());
    }
    
}
