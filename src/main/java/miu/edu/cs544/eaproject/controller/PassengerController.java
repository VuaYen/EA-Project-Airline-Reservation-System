package miu.edu.cs544.eaproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passenger/")
@PreAuthorize("hasRole('ROLE_PASSENGER')")
public class PassengerController {
}
