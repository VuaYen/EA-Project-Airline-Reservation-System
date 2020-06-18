package miu.edu.cs544.eaproject.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgentReservationCreateRequest {

    int flightId;
    int passengerId;

}
