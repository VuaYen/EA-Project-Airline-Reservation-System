package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.domain.Reservation;
import miu.edu.cs544.eaproject.exception.NotAcceptableException;
import miu.edu.cs544.eaproject.service.AirportService;
import miu.edu.cs544.eaproject.service.ReservationService;
import org.aspectj.lang.NoAspectBoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping(value = {"create"})
    public ResponseEntity<List<Reservation>> reservations(@RequestBody List<Integer> flightIds) throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        int currentUserId = 1;

        reservations = reservationService.createListReservation(flightIds, currentUserId, currentUserId);

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
}
