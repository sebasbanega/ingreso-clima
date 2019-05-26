package com.sebastian.ingreso.service.impl.weather.calculator;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.enums.WeatherEnum;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.util.MathUtil;

@Component(PlanetsAlignedCalculator.NAME)
public class PlanetsAlignedCalculator implements WeatherCalculator {

	public static final String NAME = "planetsAlignedCalculator";

	@Override
	public Period calculateWeather(List<Planet> planets, int day) {
		boolean sunAligned = MathUtil.areDotsAligned(planets.get(0).calculateXPosition(day),
				planets.get(0).calculateYPosition(day), planets.get(1).calculateXPosition(day),
				planets.get(1).calculateYPosition(day), 0d, 0d);
		Period period = new Period();
		period.setDay(day);
		if (sunAligned) {
			period.setWeather(WeatherEnum.SEQUIA);
		} else {
			period.setWeather(WeatherEnum.OPTIMO);
		}
		return period;
	}

}
