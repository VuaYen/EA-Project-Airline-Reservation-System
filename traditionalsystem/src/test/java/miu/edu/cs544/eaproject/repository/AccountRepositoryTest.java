package miu.edu.cs544.eaproject.repository;
import miu.edu.cs544.eaproject.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Test
    public void countAccountinSystem() throws Exception{
        List<Account> accounts = toList(accountRepository.findAll());
        assertEquals(6, accounts.size());
    }


}
