package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("AGENT")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Agent extends Account {

    public Agent(String username, @NotEmpty @NotNull String password, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email) {
        super(username, password, firstName, lastName,  email);
    }
}
