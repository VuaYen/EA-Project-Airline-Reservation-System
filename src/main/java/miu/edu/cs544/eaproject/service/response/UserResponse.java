package miu.edu.cs544.eaproject.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String accountType;
}