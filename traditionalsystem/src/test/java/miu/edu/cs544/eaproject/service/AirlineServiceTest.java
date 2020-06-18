package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airline;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class AirlineServiceTest {
    @Autowired
    private AirlineService airlineService;
    
    @Test
    public  void findAirlineById() throws Exception{
        String airline = airlineService.getAirlineById(1).getName();
//        System.out.println(airline);
        assertEquals("American Airlines",airline);
    }
}
