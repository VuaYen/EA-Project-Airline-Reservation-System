package miu.edu.cs544.eaproject.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@DiscriminatorValue("ROLE_PASSENGER")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "id", columnDefinition = "bigint unsigned")
    private Integer id;

    private String name;

    private String email;

    private String phone;

    private Date DOB; //Date of birth

    @Embedded
    public Address address;

}
