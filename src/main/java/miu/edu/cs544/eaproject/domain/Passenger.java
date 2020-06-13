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
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PASSENGER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger extends Account {

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="addressId")
//    @Valid
//    private Address billingAddress;

    @Embedded
    private Address address;



    public Passenger(String username, @NotEmpty @NotNull String password, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email) {
        super(username, password, firstName, lastName,  email);
    }


}
