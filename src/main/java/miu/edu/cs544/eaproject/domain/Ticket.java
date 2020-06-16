package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ticket")
public class Ticket {
    @Id
    private Integer id;

    @Size( min = 20, max = 20, message = "{error.size}")
    private String number;
    @OneToOne
    private Reservation reservation;

    private Date flightdate;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;
}
