package miu.edu.cs544.eaproject.repository;

import miu.edu.cs544.eaproject.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository1 extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
