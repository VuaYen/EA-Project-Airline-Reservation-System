package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;

import miu.edu.cs544.eaproject.domain.Airline;
import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.Ticket;
import miu.edu.cs544.eaproject.service.*;
import miu.edu.cs544.eaproject.service.response.AirlineResponse;
import miu.edu.cs544.eaproject.service.response.AirportResponse;
import miu.edu.cs544.eaproject.service.response.FlightResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("free")
public class GuestController {
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
    private AccountService accountService;

    @GetMapping(value = {"", "/"})
    public List<AirportResponse> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/airports")
    public List<AirportResponse> getAllAirports1() {
        return airportService.getAllAirports();
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


}
