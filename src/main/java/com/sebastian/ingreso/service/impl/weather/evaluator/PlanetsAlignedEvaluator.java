package com.sebastian.ingreso.service.impl.weather.evaluator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.service.impl.weather.calculator.PlanetsAlignedCalculator;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.service.weather.WeatherEvaluator;
import com.sebastian.ingreso.util.MathUtil;

@Component(PlanetsAlignedEvaluator.NAME)
public class PlanetsAlignedEvaluator implements WeatherEvaluator {

	public static final String NAME = "planetsAlignedEvaluator";

	@Autowired
	@Qualifier(TriangleEvaluator.NAME)
	private WeatherEvaluator next;

	@Autowired
	@Qualifier(PlanetsAlignedCalculator.NAME)
	private WeatherCalculator planetsAlignedCalculator;

	@Override
	public WeatherCalculator evaluate(List<Planet> planets, int day) {
		return planetsAligned(planets, day) ? planetsAlignedCalculator : next.evaluate(planets, day);
	}

	private boolean planetsAligned(List<Planet> planets, int day) {
		Map<String, Double> coordinates = planetsCoordinates(planets, day);
		return MathUtil.areDotsAligned(coordinates.get("x1"), coordinates.get("y1"), coordinates.get("x2"),
				coordinates.get("y2"), coordinates.get("x3"), coordinates.get("y3"));
	}

	private Map<String, Double> planetsCoordinates(List<Planet> planets, int day) {
		Map<String, Double> coordinates = new HashMap<>();
		int i = 1;
		for (Planet planet : planets) {
			double x = planet.calculateXPosition(day);
			double y = planet.calculateYPosition(day);
			coordinates.put("x" + i, x);
			coordinates.put("y" + i, y);
			i++;
		}
		return coordinates;
	}

}
