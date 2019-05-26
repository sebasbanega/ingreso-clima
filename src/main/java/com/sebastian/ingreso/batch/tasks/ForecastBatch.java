package com.sebastian.ingreso.batch.tasks;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.service.PlanetService;
import com.sebastian.ingreso.service.weather.WeatherService;

public class ForecastBatch implements Tasklet{
	
	private static final Logger logger = Logger.getLogger(ForecastBatch.class.toString());
	
	private WeatherService weatherService;
	private PlanetService planetService;

	public ForecastBatch(WeatherService weatherService, PlanetService planetService) {
		this.weatherService = weatherService;
		this.planetService = planetService;
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		logger.log(Level.INFO, "calculando pronóstico a 10 años terrestres... ");
		List<Planet> planets = planetService.findAll();
		weatherService.calculatePeriodsByOrbit(planets, 3650);
		return RepeatStatus.FINISHED;
	}

}
