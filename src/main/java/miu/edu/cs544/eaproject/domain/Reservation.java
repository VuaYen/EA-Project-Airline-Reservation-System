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
@Table(name = "reservation")
public class Reservation {
    @Id
    @Size(min = 6, max = 6, message = "{error.size}")
    private String code;

    private ReservationStatus status;
    private Date createdDate;

    @ManyToOne
    private Flight flight;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Account createdBy;

}
