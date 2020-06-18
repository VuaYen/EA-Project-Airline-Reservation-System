package cs544Project.userService.controller;


import cs544Project.userService.service.AccountService;
import cs544Project.userService.service.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public UserResponse viewReservationsDetails(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/get-by-username/{username}")
    public UserResponse viewReservationsDetails(@PathVariable String username) {
        return accountService.getAccountByUsername(username);
    }
}
