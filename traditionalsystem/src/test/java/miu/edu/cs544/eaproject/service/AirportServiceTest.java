package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.repository.AirportRepository;
import miu.edu.cs544.eaproject.service.response.AirportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class AirportServiceTest {
    @Autowired
    private AirportService airportService;
    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void FindAirportByID()  throws Exception{
        System.out.println(airportService.getAirportById(1));
        Airport airport =airportRepository.findById(1).get();
        AirportResponse airportResponse =airportService.getAirportById(1);
        assertEquals( airport.getName(),airportResponse.getName());
//        return airportService.getAirportById(1);
    }
}
