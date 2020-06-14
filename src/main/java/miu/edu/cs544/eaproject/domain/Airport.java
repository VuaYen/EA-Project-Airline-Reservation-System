package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Airport {
    @Id
    private Integer id;
    @Size(min = 3, max = 3, message = "{error.size}")
    private String code;
    private String name;

    @Embedded
    private Address address;

}
