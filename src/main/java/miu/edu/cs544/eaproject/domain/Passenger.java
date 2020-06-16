package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PASSENGER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger extends Account {

    private Date DOB; //Date of birth

    @Embedded
    private Address address;

//    @OneToMany (mappedBy = "passenger")
//    private List<Reservation> reservations;

//    @OneToMany (mappedBy = "passenger")
//    private List<Ticket> tickets;




    public Passenger(String username, @NotEmpty @NotNull String password, @NotEmpty String firstName, @NotEmpty String lastName,Date DOB, @NotEmpty @Email String email,Address address) {
        super(username, password, firstName, lastName,  email);
        this.DOB= DOB;
        this.address=address;

    }


}
