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
//    @Column(name = "reservationCode")
    private Reservation reservation;

    private Date flightdate;

    @ManyToOne
//    @Column(name = "flight_id")
    private Flight flight;

    @ManyToOne
//    @Column(name = "passenger_id")
    private Passenger passenger;
}
