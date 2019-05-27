package com.sebastian.ingreso.evaluator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sebastian.ingreso.IngresoMeliApplicationTests;
import com.sebastian.ingreso.service.impl.weather.calculator.PlanetsAlignedCalculator;
import com.sebastian.ingreso.service.impl.weather.calculator.TriangleCalculator;
import com.sebastian.ingreso.service.impl.weather.evaluator.PlanetsAlignedEvaluator;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.service.weather.WeatherEvaluator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluatorTests extends IngresoMeliApplicationTests {

	@Autowired
	@Qualifier(PlanetsAlignedEvaluator.NAME)
	private WeatherEvaluator weatherEvaluator;


	@Test
	public void when_planets_aligned_should_return_aligned_calculator() {
		WeatherCalculator calculator = weatherEvaluator.evaluate(planets, 90);
		assertNotNull(calculator);
		assertThat(PlanetsAlignedCalculator.class.isInstance(calculator), is(true));
	}
	
	@Test
	public void when_planets_not_aligned_should_return_triangle_calculator() {
		WeatherCalculator calculator = weatherEvaluator.evaluate(planets, 91);
		assertNotNull(calculator);
		assertThat(TriangleCalculator.class.isInstance(calculator), is(true));
	}

}
