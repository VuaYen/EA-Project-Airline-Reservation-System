package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "{error.string.empty}")
    private String number;

    private Integer capacity;
    private Date departureTime;
    private Date arivalTime;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arivalAirport;

    @ManyToOne
    @JsonIgnore
    private Airline airline;


}
