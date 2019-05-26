package com.sebastian.ingreso.repository;

import org.springframework.data.repository.CrudRepository;

import com.sebastian.ingreso.entity.Planet;

public interface PlanetRepository extends CrudRepository<Planet, Long> {

}
