package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("passengers")
//@PreAuthorize("hasRole('ROLE_PASSENGER')")
public class PassengerController {
    @Autowired
    private AirportService airportService;

    @GetMapping(value = {"", "/"})
    public List<Airport> getAllAirports()
    {
        return airportService.viewAirports();
    }

}
