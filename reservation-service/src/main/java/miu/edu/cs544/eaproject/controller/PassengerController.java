package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.service.*;
import miu.edu.cs544.eaproject.service.response.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("passengers")
@PreAuthorize("hasAnyRole('PASSENGER')")
public class PassengerController {
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
        return reservationService.getReservationByCode(code);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.viewTickets();
    }

    @GetMapping("/airlines/{code}")
    public List<Airline> getAllAirlinesFlightOutAirport(@PathVariable(name = "code") String code) throws Exception {
        return flightService.viewAllFlightsOutAirport(code);
    }

    @GetMapping("/findAirlinesByFlightDepartureAirportCode/{code}")
    public List<AirlineResponse> getAirlinesByFlightsDepartureAirportCode(@PathVariable String code) {
        return airlineService.getAirlinesByFlightsDepartureAirportCode(code);
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

}
