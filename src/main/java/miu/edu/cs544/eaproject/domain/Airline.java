package miu.edu.cs544.eaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SecondaryTable(name = "History")
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String name;

    @Column(table = "History", length = 2000, nullable = true)
    private String history; //optional field with a maximum length of 2000 characters

    @OneToMany (mappedBy = "airline")
//    @Column(name = "flight_id")
    private List<Flight> flights;
}
