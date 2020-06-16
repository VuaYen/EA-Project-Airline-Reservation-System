package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "flight")
public class Flight {
    @Id
    private Integer id;
    @NotEmpty(message = "{error.string.empty}")
    private String number;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arival_airport_id")
    private Airport arivalAirport;

    @ManyToOne
    private Airline airline;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arival_time")
    private Date arivalTime;
}
