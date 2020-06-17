package miu.edu.cs544.eaproject.service;



import miu.edu.cs544.eaproject.domain.Role;
import miu.edu.cs544.eaproject.service.dto.RoleDto;

import java.util.List;

public interface RoleService {
	
	public List<RoleDto> findAllRoles();
	
	public RoleDto createRole(RoleDto roleDto);
	
	List<RoleDto> convertEntityListToResponseList(List<Role> entityList);
	
	public RoleDto deleteRole(String roleName);

}
