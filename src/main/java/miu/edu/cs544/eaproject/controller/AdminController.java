package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
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

}
