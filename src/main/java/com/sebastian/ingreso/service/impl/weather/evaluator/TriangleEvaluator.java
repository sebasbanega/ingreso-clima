package com.sebastian.ingreso.service.impl.weather.evaluator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.service.impl.weather.calculator.TriangleCalculator;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.service.weather.WeatherEvaluator;

@Component(TriangleEvaluator.NAME)
public class TriangleEvaluator implements WeatherEvaluator {
	
	public static final String NAME = "triangleEvaluator";

	private static final int REQUIRED_PLANETS = 3;

	@Autowired
	@Qualifier(TriangleCalculator.NAME)
	private WeatherCalculator triangleCalculator;

	@Override
	public WeatherCalculator evaluate(List<Planet> planets, int day) {
		return planets.size() == REQUIRED_PLANETS ? triangleCalculator : null;
	}

}
