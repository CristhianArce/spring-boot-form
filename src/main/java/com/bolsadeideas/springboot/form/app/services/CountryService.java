package com.bolsadeideas.springboot.form.app.services;

import java.util.List;

import com.bolsadeideas.springboot.form.app.models.domain.Country;

public interface CountryService {
	public List<Country> getAll();
	public Country getById(Integer id);
}
