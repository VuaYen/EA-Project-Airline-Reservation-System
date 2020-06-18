package miu.edu.cs544.eaproject.securiry;

import miu.edu.cs544.eaproject.domain.Account;
import miu.edu.cs544.eaproject.domain.Admin;
import miu.edu.cs544.eaproject.domain.Agent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImp {

//    private final Account account;
//
//    public UserDetailsImp(Account account) {
//        this.account = account;
//    }
//
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> roles = new ArrayList<>();
//        String roleName = "";
//        if (account instanceof Admin) {
//            roleName = "ROLE_ADMIN";
//        } else if (account instanceof Agent) {
//            roleName = "ROLE_AGENT";
//        } else {
//            roleName = "ROLE_PASSENGER";
//        }
//
//        //String roleName = type == 0 ? "ADMIN" : (type == 1 ? "SELLER" : "BUYER");
//        roles.add(new SimpleGrantedAuthority(roleName));
//        return roles;
//    }
//
//    public String getPassword() {
//        return account.getPassword();
//    }
//
//    public String getUsername() {
//        return account.getUsername();
//    }
//
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }


}
