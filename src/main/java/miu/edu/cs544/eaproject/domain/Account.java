package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Account {
    @Id
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    @NotEmpty(message = "{error.string.empty}")
//    @NotNull
    @Size(min = 6, message = "{error.password.size}")
    private String password;

    @NotEmpty(message = "{error.string.empty}")
//    @NotNull
//    @Column(nullable = false)
    @Size(min = 2, max = 10, message = "{error.size}")
    private String firstName;

    @NotEmpty(message = "{error.string.empty}")
//    @NotNull
    @Column(nullable = false)
    @Size(min = 3, max = 20, message = "{error.size}")
    private String lastName;



    @NotEmpty(message = "{error.string.empty}")
//    @NotNull
    @Column(nullable = false)
    @Email
    private String email;
}
