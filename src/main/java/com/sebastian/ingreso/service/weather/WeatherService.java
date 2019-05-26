package com.sebastian.ingreso.service.weather;

import java.util.List;

import com.sebastian.ingreso.entity.Planet;

public interface WeatherService {

	// calcula los periodos para la cantidad de dias
	void calculatePeriodsByOrbit(List<Planet> planets, int days);
}
