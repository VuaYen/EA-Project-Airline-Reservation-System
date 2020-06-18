package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.domain.User;
import miu.edu.cs544.eaproject.integration.Jwt;
import miu.edu.cs544.eaproject.service.UserService;
import miu.edu.cs544.eaproject.service.dto.AuthRequest;
import miu.edu.cs544.eaproject.service.dto.AuthResponse;
import miu.edu.cs544.eaproject.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Jwt jwt;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid email/password");
		}
		final UserDetails user = userService.loadUserByUsername(authRequest.getUsername());
		String token = jwt.generateToken(user.getUsername());
		return ResponseEntity.ok(new AuthResponse(token, "Login success", HttpStatus.OK.value()));
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/json" })
	@Secured({ "ROLE_ADMIN" })
	public UserDto createUser(@RequestBody UserDto userDto) throws Exception {

		return userService.createUser(userDto);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@Secured({ "ROLE_ADMIN" })
	public Boolean deleteUser(@PathVariable long userId) throws Exception {

		return userService.deleteUser(userId);
	}

	@GetMapping(value = {"", "/"})
	@Secured({ "ROLE_ADMIN" })
	public List<User> getListUsers()
	{
		return userService.viewListUser();
	}
}
