package com.sebastian.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.repository.PlanetRepository;
import com.sebastian.ingreso.service.PlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public List<Planet> findAll() {
		List<Planet> planets = (List<Planet>) planetRepository.findAll();
		return planets;
	}

}
