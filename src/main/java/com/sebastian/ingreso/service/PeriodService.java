package com.sebastian.ingreso.service;

import java.util.List;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.enums.WeatherEnum;

public interface PeriodService {

	int maxDayByWeather(WeatherEnum weather);
	
	List<Period> findByWeather(WeatherEnum weather);

	void savePeriods(List<Period> periods);
	
	int countByPeriod(WeatherEnum weather);
	
	Period findByDay(int day);
}
