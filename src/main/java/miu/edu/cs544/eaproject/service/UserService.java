package miu.edu.cs544.eaproject.service;

import miu.edu.cs544.eaproject.domain.*;
import miu.edu.cs544.eaproject.repository.AccountRepository;
import miu.edu.cs544.eaproject.repository.RoleRepository;
import miu.edu.cs544.eaproject.repository.UserRepository;
import miu.edu.cs544.eaproject.service.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : user.getUserRole()) {
			 authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	}
	
	public UserDto createUser(UserDto userDto) {
		
		User user = modelMapper.map(userDto, User.class);
		Role role = roleRepository.findById((new Long(userDto.getRoleId()))).get();
		user.addRole(role);
		userRepository.save(user);
		createAccount(user,role);

		return convertEntityToResponse(user);
	}
	
	public Boolean deleteUser(long userId) {
		accountRepository.deleteById(userId);
		userRepository.deleteById(userId);
		return true;
	}
	
	public UserDto convertEntityToResponse(User entity) {
		// TODO Auto-generated method stub
		if (null == entity) {
			return null;
		} else {
			return modelMapper.map(entity, UserDto.class);
		}
	}

	public void createAccount (User user, Role role)
	{
		Account account;
		if (role.getRoleName()=="PASSENGER")
			account= new Passenger();
		else
			account= new Agent();
		account.setFirstName(user.getFirstName());
		account.setLastName(user.getLastName());
		account.setEmail(user.getEmail());
		account.setUsername(user.getUserName());
		account.setPassword(user.getPassword());
		account.setId((int) user.getId());
		accountRepository.save(account);
	}

	public List<User> viewListUser(){
		return toList(userRepository.findAll());
	}
	public static <T> List<T> toList(final Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
	}
	
}
