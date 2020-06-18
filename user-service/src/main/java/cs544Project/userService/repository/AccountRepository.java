package cs544Project.userService.repository;

import cs544Project.userService.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT DISTINCT u FROM Account u WHERE u.userName = :username")
    Account findByUsername(@Param("username") String username);
}