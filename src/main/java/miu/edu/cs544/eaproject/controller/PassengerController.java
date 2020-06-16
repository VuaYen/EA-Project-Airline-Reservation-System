package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Flight;
import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.service.AirlineService;
import miu.edu.cs544.eaproject.service.FlightService;
import miu.edu.cs544.eaproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/passenger")
@PreAuthorize("hasRole('ROLE_PASSENGER')")
public class PassengerController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/findAirlinesByFlightDepartureAirportCode/{code}")
    public List<Airline> getAirlinesByFlightsDepartureAirportCode(@PathVariable String code) {
        return airlineService.getAirlinesByFlightsDepartureAirportCode(code);
    }

    @GetMapping("/findFlightsByDepartureAndDestinationForDate")
    public List<Flight> getFlightsByDepartureAndDestinationForDate(@RequestParam String DACode,
                                                                   @RequestParam String AACode,
                                                                   @RequestParam Date departureTime) {
        return flightService.getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(DACode, AACode, departureTime);
    }

    @GetMapping("/findReservationsByPassengerId/{id}")
    public List<Reservation> getReservationsByPassengerId(@PathVariable Integer id) {
        return reservationService.getReservationsByPassengerId(id);
    }
}
