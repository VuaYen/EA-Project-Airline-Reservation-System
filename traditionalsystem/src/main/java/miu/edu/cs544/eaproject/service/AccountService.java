package miu.edu.cs544.eaproject.service;



import miu.edu.cs544.eaproject.domain.Account;
import miu.edu.cs544.eaproject.repository.AccountRepository1;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {

    public <T extends Account> boolean createAccount(T account);
    public <T extends Account> T saveProfile(T account);






    public <T extends Account> T getByUsername(String username);
//    public Account getByUsername1(String username);
}
