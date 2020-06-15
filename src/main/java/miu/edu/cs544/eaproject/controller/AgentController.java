package miu.edu.cs544.eaproject.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
import miu.edu.cs544.eaproject.domain.Airport;
import miu.edu.cs544.eaproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("agents")
//@PreAuthorize("hasRole('ROLE_AGENT')")
public class AgentController {
    @Autowired
    private AirportService airportService;

    @GetMapping(value = {"", "/"})
    public List<Airport> getAllAirports()
    {
        return airportService.viewAirports();
    }

}
