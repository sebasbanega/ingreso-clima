package com.sebastian.ingreso.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.service.PeriodService;
import com.sebastian.ingreso.service.impl.weather.evaluator.PlanetsAlignedEvaluator;
import com.sebastian.ingreso.service.weather.WeatherCalculator;
import com.sebastian.ingreso.service.weather.WeatherEvaluator;
import com.sebastian.ingreso.service.weather.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	@Qualifier(PlanetsAlignedEvaluator.NAME)
	private WeatherEvaluator evaluator;

	@Autowired
	private PeriodService periodService;

	@Override
	public void calculatePeriodsByOrbit(List<Planet> planets, int days) {
		List<Period> periods = new LinkedList<>();
		IntStream.range(1, days).forEach(day -> {
			WeatherCalculator calculator = evaluator.evaluate(planets, day);
			Period period = calculator.calculateWeather(planets, day);
			periods.add(period);
			if (periods.size() == 1000 || day == days) {
				persistPeriods(periods);
				periods.clear();
			}
		});
	}

	private void persistPeriods(List<Period> periods) {
		periodService.savePeriods(periods);
	}

}
