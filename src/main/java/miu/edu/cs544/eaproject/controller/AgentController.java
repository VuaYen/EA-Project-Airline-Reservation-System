package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("agents")
//@PreAuthorize("hasRole('ROLE_AGENT')")
public class AgentController {
    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AirlineService airlineService;

    @GetMapping(value = {"", "/"})
    public List<Airport> getAllAirports()
    {
        return airportService.viewAirports();
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports1()
    {
        return airportService.viewAirports();
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights()
    {
        return flightService.viewAllFlights();
    }

    @GetMapping("/airlines")
    public List<Airline> getAllAirlines()
    {
        return airlineService.viewAirlines();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations()
    {
        return reservationService.viewReservations();
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets()
    {
        return ticketService.viewTickets();
    }

    @GetMapping("/airlines/{code}")
    public List<Airline> getAllAirlinesFlightOutAirport(@PathVariable(name = "code") String code) throws Exception
    {
        return flightService.viewAllFlightsOutAirport(code);
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
