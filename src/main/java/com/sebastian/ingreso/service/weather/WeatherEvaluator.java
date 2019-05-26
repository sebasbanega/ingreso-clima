package com.sebastian.ingreso.service.weather;

import java.util.List;

import com.sebastian.ingreso.entity.Planet;

@FunctionalInterface
public interface WeatherEvaluator {

	WeatherCalculator evaluate(List<Planet> planets, int day);
}
