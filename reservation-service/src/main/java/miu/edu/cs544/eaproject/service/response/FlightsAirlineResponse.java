package miu.edu.cs544.eaproject.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightsAirlineResponse implements Serializable {
    private Integer id;
    private String number;
    private Integer capacity;
    private AirlineResponse airline;
    private Date arivalTime;
}
