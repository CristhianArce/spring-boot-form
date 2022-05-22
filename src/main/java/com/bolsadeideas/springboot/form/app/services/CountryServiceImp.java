package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Country;

@Service
public class CountryServiceImp implements CountryService {

	private List<Country> countries;
	
	public CountryServiceImp() {
		this.countries = Arrays.asList(
				new Country(1, "CO", "Colombia"),
				new Country(2, "MX", "México"),
				new Country(3, "AR", "Argentina"),
				new Country(4, "PE", "Perú"),
				new Country(5, "CL", "Chile"),
				new Country(6, "EC", "Ecuador!"));
	}

	@Override
	public List<Country> getAll() {
		return countries;
	}

	@Override
	public Country getById(Integer id) {
		Country result = null;
		for(Country country: this.countries) {
			if(id == country.getId()) {
				result = country;
				break;
			}
		}
		return result;
	}

}
