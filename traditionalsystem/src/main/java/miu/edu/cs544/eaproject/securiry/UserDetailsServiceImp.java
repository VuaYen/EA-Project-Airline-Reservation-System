package miu.edu.cs544.eaproject.securiry;


import miu.edu.cs544.eaproject.domain.Account;
import miu.edu.cs544.eaproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp  {

//    private AccountService accountService;
//
//    @Autowired
//    public UserDetailsServiceImp(AccountService accountService) {
//        this.accountService = accountService;
//    }
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountService.getByUsername(username);
//
//        if (account != null) {
//            return new UserDetailsImp(account);
//        } else {
//            throw new UsernameNotFoundException("User " + username + " not found!");
//        }
//    }
}
