package miu.edu.cs544.eaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("home")
public class HelloWordController {
    @GetMapping(value = {"", "/"})
    public String HelloWord(){
        return  "<div><h1>Welcome to EA Project Group 8 Description – June 2020.</h1> <br>We are trying to create a RESTful application (the backend part of it; no UI ) for an “Airline Reservation System” </div> ";
    }
    @GetMapping(value = {"/name"})
    public String projectName(){
        return  "Airline Reservation System";
    }
}
