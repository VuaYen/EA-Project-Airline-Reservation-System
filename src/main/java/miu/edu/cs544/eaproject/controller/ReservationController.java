package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.domain.Ticket;
import miu.edu.cs544.eaproject.service.ReservationService;
import miu.edu.cs544.eaproject.service.UserService;
import miu.edu.cs544.eaproject.service.request.AgentReservationCreateRequest;
import miu.edu.cs544.eaproject.service.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyRole('PASSENGER')")
    @PostMapping(value = {"/passenger/create"})
    public List<Reservation> reservations(@RequestBody List<Integer> flightIds) {
        List<Reservation> reservations = new ArrayList<>();
        int currentUserId = userService.getCurrentUserId();
        reservations = reservationService.createListReservation(flightIds, currentUserId, currentUserId);
        return reservations;
    }

    @PreAuthorize("hasAnyRole('PASSENGER')")
    @PutMapping(value = {"/confirm"})
    public List<Ticket> confirmReservations(@RequestBody List<String> flightCodes) {
        List<Ticket> tickets = new ArrayList<>();
        int currentUserId = userService.getCurrentUserId();
        tickets = reservationService.confirmReservation(flightCodes, currentUserId);
        return tickets;
    }

    @PreAuthorize("hasAnyRole('PASSENGER') OR hasAnyRole('AGENT')")
    @PutMapping(value = {"/cancel/{code}"})
    public ResponseEntity<String> cancelReservations(@PathVariable String code) {
        List<Ticket> tickets = new ArrayList<>();
        int currentUserId = userService.getCurrentUserId();
        if(reservationService.cancelReservations(code, currentUserId)) {
            return ResponseEntity.status(HttpStatus.OK).body("The reservation " + code + " is canceled!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The reservation " + code + " can not canceled!");
    }

    @PreAuthorize("hasAnyRole('AGENT')")
    @PostMapping(value = {"/agent/create"})
    public List<Reservation> agentReservations(@RequestBody List<AgentReservationCreateRequest> listReservation) {
        List<Reservation> reservations = new ArrayList<>();
        int currentUserId = userService.getCurrentUserId();
        for (AgentReservationCreateRequest agentReservationRequest:
                listReservation) {
            System.out.println(agentReservationRequest.getFlightId());
        }
        reservations = reservationService.createListReservationByAgent(listReservation, currentUserId);
        return reservations;
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('PASSENGER') OR hasAnyRole('AGENT')")
    public Reservation viewReservationsDetails(@PathVariable String code) {
        return reservationService.getReservationByCode(code);
    }

}
