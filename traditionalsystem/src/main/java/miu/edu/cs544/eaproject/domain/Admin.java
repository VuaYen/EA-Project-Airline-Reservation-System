package miu.edu.cs544.eaproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Account {
    public Admin(int id, String username, @NotEmpty @NotNull String password, @NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty @Email String email) {
        super(id, username, password, firstName, lastName, email);
    }


}
