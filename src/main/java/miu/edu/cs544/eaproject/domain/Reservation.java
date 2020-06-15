package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
