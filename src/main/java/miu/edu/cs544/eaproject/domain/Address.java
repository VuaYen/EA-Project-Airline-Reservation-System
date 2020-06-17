package miu.edu.cs544.eaproject.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
}
