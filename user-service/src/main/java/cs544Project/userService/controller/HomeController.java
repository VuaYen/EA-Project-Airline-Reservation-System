package cs544Project.userService.controller;


import cs544Project.userService.domain.Account;
import cs544Project.userService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
//@RequestMapping("/")
public class HomeController {

    @Autowired
    AccountService accountService;

//    @GetMapping("")
    public String viewReservationsDetails(OAuth2Authentication auth) {
        return "this.accountService.getAccountById(id)";
    }

}
