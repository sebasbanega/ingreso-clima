package com.sebastian.ingreso.service.impl.weather.calculator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.enums.WeatherEnum;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.util.MathUtil;

@Component(value = TriangleCalculator.NAME)
public class TriangleCalculator implements WeatherCalculator {

	public static final String NAME = "triangleCalculator";

	@Override
	public Period calculateWeather(List<Planet> planets, int day) {
		Period period = new Period();
		period.setDay(day);
		if (isSunInsideTriangle(planets, day)) {
			period.setWeather(WeatherEnum.LLUVIA);
		} else {
			period.setWeather(WeatherEnum.NORMAL);
		}
		
		return period;
	}

	private boolean isSunInsideTriangle(List<Planet> planets, int day) {
		Boolean condition = false;
		if (planets.size() == 3) {
			Double triangleArea = MathUtil.area(planets.get(0).calculateXPosition(day),
					planets.get(0).calculateYPosition(day), planets.get(1).calculateXPosition(day),
					planets.get(1).calculateYPosition(day), planets.get(2).calculateXPosition(day),
					planets.get(2).calculateYPosition(day));

			Double triangleAreaSunWithPlanet2AndPlanet3 = MathUtil.area(0D, 0D, planets.get(1).calculateXPosition(day),
					planets.get(1).calculateYPosition(day), planets.get(2).calculateXPosition(day),
					planets.get(2).calculateYPosition(day));

			Double triangleAreaSunWithPlanet1AndPlanet3 = MathUtil.area(planets.get(0).calculateXPosition(day),
					planets.get(0).calculateYPosition(day), 0D, 0D, planets.get(2).calculateXPosition(day),
					planets.get(2).calculateYPosition(day));

			Double triangleAreaSunWithPlanet1AndPlanet2 = MathUtil.area(planets.get(0).calculateXPosition(day),
					planets.get(0).calculateYPosition(day), planets.get(1).calculateXPosition(day),
					planets.get(1).calculateYPosition(day), 0D, 0D);

			condition = (triangleArea == triangleAreaSunWithPlanet2AndPlanet3 + triangleAreaSunWithPlanet1AndPlanet3
					+ triangleAreaSunWithPlanet1AndPlanet2);
		}
		return condition;
	}

}
