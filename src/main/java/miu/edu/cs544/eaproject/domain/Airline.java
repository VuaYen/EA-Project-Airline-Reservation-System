package miu.edu.cs544.eaproject.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@SecondaryTable(name = "History")
public class Airline {
    @Id
    private  Integer id;

    private String code;

    private String name;

    @Column(table = "History", length = 2000, nullable = true)
    private String history; //optional field with a maximum length of 2000 characters

    @OneToMany (mappedBy = "airline")
    @Column(name = "flight_id")
    private List<Flight> flights;
}
