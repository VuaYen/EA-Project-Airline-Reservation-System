package cs544Project.userService.service;

import cs544Project.userService.domain.Account;
import cs544Project.userService.repository.AccountRepository;
import cs544Project.userService.service.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserResponse getAccountById(int id) {
        return accountRepository.findById(id).map(this::convertAccountToUserResponse).get();
    }

    @Override
    public UserResponse getAccountByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return convertAccountToUserResponse(account);
    }

    private UserResponse convertAccountToUserResponse(Account account) {
        return new UserResponse(account.getId(), account.getUserName(), account.getFirstName(),
                account.getLastName(), account.getEmail(), account.getAccountType());
    }
}
