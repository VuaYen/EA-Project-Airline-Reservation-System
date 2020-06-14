package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    private Integer id;
    private String number;
    private Integer capacity;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arivalAirport;

    @ManyToOne
    private Airline airline;

    private Date departureTime;
    private Date arivalTime;
}
