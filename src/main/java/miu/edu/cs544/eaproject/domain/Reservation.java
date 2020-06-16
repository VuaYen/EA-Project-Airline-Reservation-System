package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "passenger_ID", columnDefinition = "bigint unsigned")
    private Integer passengerID;

    @Column(name = "created_by", columnDefinition = "bigint unsigned")
    private Integer createdBy;

    @ManyToOne
    private Account createdBy;

}
