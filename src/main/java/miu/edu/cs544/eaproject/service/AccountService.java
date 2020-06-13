package miu.edu.cs544.eaproject.service;



import miu.edu.cs544.eaproject.domain.Account;

import java.util.List;

public interface AccountService {

    public <T extends Account> boolean createAccount(T account);
    public <T extends Account> T saveProfile(T account);





    public <T extends Account> T getByUsername(String username);
//    public Account getByUsername1(String username);
}
