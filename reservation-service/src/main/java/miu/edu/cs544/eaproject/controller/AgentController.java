package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;

import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.service.*;
import miu.edu.cs544.eaproject.service.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("agents")
@PreAuthorize("hasAnyRole('AGENT')")
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

    @Autowired
    private PassengerService passengerService;

    @GetMapping(value = {"", "/"})
    public List<AirportResponse> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airports")
    public List<AirportResponse> getAllAirports1() {
        return airportService.getAllAirports();
    }

    @GetMapping("/flights")
    public List<FlightResponse> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/airlines")
    public List<AirlineResponse> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.viewReservations();
    }

    @GetMapping("/reservations/{code}")
    public Reservation viewDetailReservationById(@PathVariable(name = "code") String code) throws Exception {
        //check this reservation by this agent.
        Integer currentAgentid = 3;
        if (reservationService.getReservationByCode(code).getCreatedBy() == currentAgentid)
            return reservationService.getReservationByCode(code);
        else
            return null;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.viewTickets();
    }

    @GetMapping("/airlines/{code}")
    public List<Airline> getAllAirlinesFlightOutAirport(@PathVariable(name = "code") String code) throws Exception {
        return flightService.viewAllFlightsOutAirport(code);
    }

    @GetMapping("/findFlightsByDepartureAndDestinationForDate")
    public List<FlightsAirlineResponse> getFlightsByDepartureAndDestinationForDate(@RequestParam String DACode,
                                                                                   @RequestParam String AACode,
                                                                                   @RequestParam Date departureTime) {
        return flightService.getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(DACode, AACode, departureTime);
    }

    @GetMapping("/findReservationsByPassengerId/{id}")
    public List<PassengerReservationsResponse> getReservationsByPassengerId(@PathVariable Integer id) {
        return reservationService.getReservationsByPassengerId(id);
    }

    @GetMapping("/myreservation")
    public List<Reservation> getMyReservations() {
        Integer userid = 2;
        return reservationService.getReservationsCreateBy(userid);
    }

    @GetMapping("/viewlistairlinesflightoutairport/{code}")
    public List<Airline> viewListAirlinesFlightoutairport(@PathVariable(name = "code") String code) throws Exception {
        return flightService.viewAllFlightsOutAirport(code);
    }

    @GetMapping("/findPassengersAndReservationsCreatedByAgentId/{id}")
    public List<PassengerAndReservationsResponse> findPassengersAndReservationsCreatedByAgentId(@PathVariable Integer id) {
        return passengerService.getPassengersAndReservationsByReservationsCreatedBy(id);
    }
}
