package cs544Project.userService.service;

import cs544Project.userService.domain.dto.CustomUserDetails;
import cs544Project.userService.domain.Account;
import cs544Project.userService.domain.dto.CustomGrantedAuthority;
import cs544Project.userService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if (account != null) {
			CustomUserDetails customUserDetails = new CustomUserDetails();
			customUserDetails.setUserName(account.getUserName());
			customUserDetails.setPassword(account.getPassword());
			customUserDetails.setId(account.getId());

			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new CustomGrantedAuthority(account.getAccountType()));
			customUserDetails.setGrantedAuthorities(authorities);

			return customUserDetails;
		}
		throw new UsernameNotFoundException(username);
	}

}
