package com.sebastian.ingreso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.enums.WeatherEnum;

public interface PeriodRepository extends CrudRepository<Period, Integer> {

	int countByWeather(WeatherEnum weather);

	List<Period> findByWeather(WeatherEnum weatherEnum);

	Period findByDay(Integer day);

}
