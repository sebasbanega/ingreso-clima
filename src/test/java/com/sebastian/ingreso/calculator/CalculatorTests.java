package com.sebastian.ingreso.calculator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sebastian.ingreso.IngresoMeliApplicationTests;
import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.enums.WeatherEnum;
import com.sebastian.ingreso.service.impl.weather.calculator.PlanetsAlignedCalculator;
import com.sebastian.ingreso.service.weather.WeatherCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTests extends IngresoMeliApplicationTests{
	
	@Autowired
	@Qualifier(PlanetsAlignedCalculator.NAME)
	private WeatherCalculator weatherCalculator;

	@Test
	public void when_planets_aligned_should_return_drought() {
		Period period = weatherCalculator.calculateWeather(planets, 90);
		assertNotNull(period);
		assertTrue(period.getWeather().name().equals(WeatherEnum.SEQUIA.name()));
	}

}
