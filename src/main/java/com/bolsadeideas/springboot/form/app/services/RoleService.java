package com.bolsadeideas.springboot.form.app.services;

import java.util.List;

import com.bolsadeideas.springboot.form.app.models.domain.Role;

public interface RoleService {
	public List<Role> getAll();

	public Role findById(Integer id);

}
