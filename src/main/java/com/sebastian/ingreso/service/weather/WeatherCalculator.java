package com.sebastian.ingreso.service.weather;

import java.util.List;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.entity.Planet;

@FunctionalInterface
public interface WeatherCalculator {

	Period calculateWeather(List<Planet> planets, int day);
}
