package miu.edu.cs544.eaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;

    public void setAccountService() throws Exception{

    }
}
