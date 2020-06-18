package miu.edu.cs544.eaproject;

import miu.edu.cs544.eaproject.controller.HelloWordController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloWordController service;

    @Test
    public void eaprojectInfo() throws Exception {
        when(service.HelloWord()).thenReturn("<div><h1>Welcome to EA Project Group 8 Description – June 2020.</h1> <br>We are trying to create a RESTful application (the backend part of it; no UI ) for an “Airline Reservation System” </div> ");
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("<div><h1>Welcome to EA Project Group 8 Description – June 2020.</h1> <br>We are trying to create a RESTful application (the backend part of it; no UI ) for an “Airline Reservation System” </div> ")));
    }

    @Test
    public void eaprojectName() throws Exception {
        when(service.HelloWord()).thenReturn("Airline Reservation System");
        this.mockMvc.perform(get("/name")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Airline Reservation System")));
    }
}
