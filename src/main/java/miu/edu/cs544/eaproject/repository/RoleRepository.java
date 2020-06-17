package miu.edu.cs544.eaproject.repository;


import miu.edu.cs544.eaproject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Role findByRoleName(String roleName);

}
