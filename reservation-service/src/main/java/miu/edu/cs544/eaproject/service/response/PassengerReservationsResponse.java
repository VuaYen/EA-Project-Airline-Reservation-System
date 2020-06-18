package miu.edu.cs544.eaproject.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.cs544.eaproject.domain.ReservationStatus;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerReservationsResponse implements Serializable {
    private String code;
    private ReservationStatus status;
    private Date createdDate;
    private String flightNumber;
    private String flightDepartureAirportCode;
    private String flightArivalAirportCode;
    private Date flightDepartureTime;
    private Date flightArivalTime;
    private Integer createdBy;
    private String passengerName;
}
