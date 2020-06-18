package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;

import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.service.*;
import miu.edu.cs544.eaproject.service.request.FlightCreateRequest;
import miu.edu.cs544.eaproject.service.response.AirlineResponse;
import miu.edu.cs544.eaproject.service.response.AirportResponse;
import miu.edu.cs544.eaproject.service.response.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin")
//@Secured({ "ROLE_ADMIN" })
public class AdminController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ReservationService reservationService;


    // Starting Airline CURD Operations
    @GetMapping("/airline/list")
    public ResponseEntity<List<AirlineResponse>> getAllAirlines() {
        List<AirlineResponse> list = airlineService.getAllAirlines();
        return new ResponseEntity<List<AirlineResponse>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<AirlineResponse> getAirlineById(@PathVariable Integer id) throws RecordNotFoundException {
        AirlineResponse airline = airlineService.getAirlineById(id);
        return new ResponseEntity<AirlineResponse>(airline, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/airline/createOrUpdate")
    public ResponseEntity<AirlineResponse> createOrUpdateAirline(@RequestBody Airline airline) throws RecordNotFoundException {
        AirlineResponse updated = airlineService.createOrUpdateAirline(airline);
        return new ResponseEntity<AirlineResponse>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/airline/deleteById/{id}")
    public HttpStatus deleteAirlineById(@PathVariable Integer id) throws RecordNotFoundException {
        airlineService.deleteAirlineById(id);
        return HttpStatus.OK;
    }

    // Starting Airport CURD Operations
    @GetMapping("/airport/list")
    public ResponseEntity<List<AirportResponse>> getAllAirports() {
        List<AirportResponse> list = airportService.getAllAirports();
        return new ResponseEntity<List<AirportResponse>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<AirportResponse> getAirportById(@PathVariable Integer id) throws RecordNotFoundException {
        AirportResponse airport = airportService.getAirportById(id);
        return new ResponseEntity<AirportResponse>(airport, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/airport/createOrUpdate")
    public ResponseEntity<AirportResponse> createOrUpdateAirport(@RequestBody Airport airport) throws RecordNotFoundException {
        AirportResponse updated = airportService.createOrUpdateAirport(airport);
        return new ResponseEntity<AirportResponse>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/airport/deleteById/{id}")
    public HttpStatus deleteAirportById(@PathVariable Integer id) throws RecordNotFoundException {
        airportService.deleteAirportById(id);
        return HttpStatus.OK;
    }

    // Starting Flight CURD Operations
    @GetMapping("/flight/list")
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        List<FlightResponse> list = flightService.getAllFlights();
        return new ResponseEntity<List<FlightResponse>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable Integer id) throws RecordNotFoundException {
        FlightResponse flight = flightService.getFlightById(id);
        return new ResponseEntity<FlightResponse>(flight, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/flight/createOrUpdate")
    public ResponseEntity<FlightResponse> createOrUpdateFlight(@RequestBody FlightCreateRequest flight) throws RecordNotFoundException {
        FlightResponse updated = flightService.createOrUpdateFlight(flight);
        return new ResponseEntity<FlightResponse>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/flight/deleteById/{id}")
    public HttpStatus deleteFlightById(@PathVariable Integer id) throws RecordNotFoundException {
        flightService.deleteFlightById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.viewReservations();
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
    public List<FlightResponse> getFlightsByDepartureAndDestinationForDate(@RequestParam String DACode,
                                                                   @RequestParam String AACode,
                                                                   @RequestParam Date departureTime) {
        return flightService.getFlightsByDepartureAirportCodeAndArivalAirportCodeAndDepartureTimeEquals(DACode, AACode, departureTime);
    }

    @GetMapping("/findReservationsByPassengerId/{id}")
    public List<Reservation> getReservationsByPassengerId(@PathVariable Integer id) {
        return reservationService.getReservationsByPassengerId(id);
    }

}
