package miu.edu.cs544.eaproject.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreateRequest {
    private Integer id;
    private Integer capacity;
    private String number;
    private Date departureTime;
    private Date arivalTime;
    private Integer airlineId;
    private Integer departureAirportId;
    private Integer arivalAirportId;

}
