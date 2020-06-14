package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Airport {
    @Id
    private Integer id;
    private String code;
    private String name;

    @Embedded
    private Address address;

}
