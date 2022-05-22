package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	private List<Role> roles;

	public RoleServiceImpl() {
		this.roles = Arrays.asList(
				new Role(1, "Administrador", "ROLE_ADMIN"),
				new Role(2, "Usuario", "ROLE_USER"),
				new Role(3, "Moderador", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> getAll() {
		return this.roles;
	}

	@Override
	public Role findById(Integer id) {
		Role result = null;
		for(Role role: roles) {
			if(id == role.getId()) {
				result = role;
				break;
			}
		}
		return result;
	}

}
