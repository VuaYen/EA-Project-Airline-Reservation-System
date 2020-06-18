package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;

import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.exception.RecordNotFoundException;
import miu.edu.cs544.eaproject.service.*;
import miu.edu.cs544.eaproject.service.request.FlightCreateRequest;
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
//@PreAuthorize("hasRole('ROLE_ADMIN')")
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
    public ResponseEntity<List<Airline>> getAllAirlines() {
        List<Airline> list = airlineService.getAllAirlines();
        return new ResponseEntity<List<Airline>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Integer id) throws RecordNotFoundException {
        Airline airline = airlineService.getAirlineById(id);
        return new ResponseEntity<Airline>(airline, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/airline/createOrUpdate")
    public ResponseEntity<Airline> createOrUpdateAirline(@RequestBody Airline airline) throws RecordNotFoundException {
        Airline updated = airlineService.createOrUpdateAirline(airline);
        return new ResponseEntity<Airline>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/airline/deleteById/{id}")
    public HttpStatus deleteAirlineById(@PathVariable Integer id) throws RecordNotFoundException {
        airlineService.deleteAirlineById(id);
        return HttpStatus.OK;
    }

    // Starting Airport CURD Operations
    @GetMapping("/airport/list")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> list = airportService.getAllAirports();
        return new ResponseEntity<List<Airport>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Integer id) throws RecordNotFoundException {
        Airport airport = airportService.getAirportById(id);
        return new ResponseEntity<Airport>(airport, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/airport/createOrUpdate")
    public ResponseEntity<Airport> createOrUpdateAirport(@RequestBody Airport airport) throws RecordNotFoundException {
        Airport updated = airportService.createOrUpdateAirport(airport);
        return new ResponseEntity<Airport>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/airport/deleteById/{id}")
    public HttpStatus deleteAirportById(@PathVariable Integer id) throws RecordNotFoundException {
        airportService.deleteAirportById(id);
        return HttpStatus.OK;
    }

    // Starting Flight CURD Operations
    @GetMapping("/flight/list")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> list = flightService.getAllFlights();
        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) throws RecordNotFoundException {
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<Flight>(flight, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/flight/createOrUpdate")
    public ResponseEntity<Flight> createOrUpdateFlight(@RequestBody FlightCreateRequest flight) throws RecordNotFoundException {
        Flight updated = flightService.createOrUpdateFlight(flight);
        return new ResponseEntity<Flight>(updated, new HttpHeaders(), HttpStatus.OK);
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
