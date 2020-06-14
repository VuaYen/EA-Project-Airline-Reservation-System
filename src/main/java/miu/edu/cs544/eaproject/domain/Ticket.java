package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {
    @Id
    private Integer id;
    private String number;
    @OneToOne
    private Reservation reservation;

    private Date flightdate;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;
}
