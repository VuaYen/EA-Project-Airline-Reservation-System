package miu.edu.cs544.eaproject;

import miu.edu.cs544.eaproject.domain.Account;
import miu.edu.cs544.eaproject.domain.Admin;
import miu.edu.cs544.eaproject.domain.Agent;
import miu.edu.cs544.eaproject.domain.Passenger;
import miu.edu.cs544.eaproject.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaprojectApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(AccountRepository accountRepository) {
        return args -> {
//            Account admin = new Admin();
//            admin.setFirstName("Admin");
//            admin.setLastName("Mr");
//            admin.setEmail("thepham@miu.edu");
//            admin.setUsername("admin");
//            admin.setPassword("$2b$10$QwKk5pHK1RhFfeFqPiaGx.7XHD/B5Y2LbxtkRJVKVOTZhezdRacwa");
//

//            accountRepository.save(admin);
//
        };
    }

}
