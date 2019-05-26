package com.sebastian.ingreso.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sebastian.ingreso.batch.tasks.ForecastBatch;
import com.sebastian.ingreso.service.PlanetService;
import com.sebastian.ingreso.service.weather.WeatherService;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private PlanetService planetService;

	@Bean
	public Step stepOne() {
		return stepBuilderFactory.get("stepOne").tasklet(runForecastBatch()).build();
	}

	@Bean
	public ForecastBatch runForecastBatch() {
		return new ForecastBatch(weatherService, planetService);
	}

	@Bean
	public Job weatherBatchJob() {
		return jobBuilderFactory.get("weatherJob").incrementer(new RunIdIncrementer()).start(stepOne()).build();
	}

}
