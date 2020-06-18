package miu.edu.cs544.eaproject.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miu.edu.cs544.eaproject.domain.Address;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerAndReservationsResponse implements Serializable {
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Date passengerDOB;
    public Address passengerAddress;

    private List<PassengerReservationsResponse> reservations;
}
