package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("agents")
//@Secured({ "ROLE_AGENT","ROLE_ADMIN" })
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
    @GetMapping("/reservations/{code}")
    public Reservation viewDetailReservationById(@PathVariable(name = "code") String code) throws Exception
    {
        //check this reservation by this agent.
        Integer currentAgentid=3;
        if (reservationService.getReservationByCode(code).getCreatedBy()==currentAgentid)
            return reservationService.getReservationByCode(code);
        else
            return null;
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

    @GetMapping("/myreservation")
    public List<Reservation> getMyReservations() {
        Integer userid=2;
        return reservationService.getReservationsCreateBy(userid);
    }
    @GetMapping("/viewlistairlinesflightoutairport/{code}")
    public List<Airline> viewListAirlinesFlightoutairport(@PathVariable(name = "code") String code) throws Exception
    {
        return flightService.viewAllFlightsOutAirport(code);
    }


}
