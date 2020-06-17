package miu.edu.cs544.eaproject.controller;

import miu.edu.cs544.eaproject.service.RoleService;
import miu.edu.cs544.eaproject.service.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	public List<RoleDto> getRoles(){
		return roleService.findAllRoles();
	}
	
	@PostMapping("/create")
	public RoleDto createRole(@RequestBody RoleDto roleDto) {
		return roleService.createRole(roleDto);
	}

	@DeleteMapping(value = "/delete",params = "Role")
	public RoleDto deleteRole(@RequestParam String Role) {
		
		return roleService.deleteRole(Role);
	}
}
