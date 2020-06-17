package miu.edu.cs544.eaproject.repository;


import miu.edu.cs544.eaproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUserName(String userName);
}
