package miu.edu.cs544.eaproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
    @Id
    private  Integer id;

    private String code;

    private String name;

    @Column(table = "History", length = 2000, nullable = true)
    private String history; //optional field with a maximum length of 2000 characters
}
