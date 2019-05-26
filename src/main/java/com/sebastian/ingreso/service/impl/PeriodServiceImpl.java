package com.sebastian.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.enums.WeatherEnum;
import com.sebastian.ingreso.repository.PeriodRepository;
import com.sebastian.ingreso.service.PeriodService;
import com.sebastian.ingreso.service.PlanetService;
import com.sebastian.ingreso.util.MathUtil;

@Service
public class PeriodServiceImpl implements PeriodService {

	@Autowired
	private PlanetService planetService;

	@Autowired
	private PeriodRepository periodRepository;

	@Override
	public int maxDayByWeather(WeatherEnum weather) {
		List<Planet> planetList = planetService.findAll();
		List<Period> periodList = findByWeather(WeatherEnum.LLUVIA);
		Double auxArea = 0D;
		Integer dayMaxRain = 0;
		if (planetList != null && planetList.size() == 3) {

			for (Period weatherPlanet : periodList) {
				Double area = MathUtil.area(planetList.get(0).calculateXPosition(weatherPlanet.getDay()),
						planetList.get(0).calculateYPosition(weatherPlanet.getDay()),
						planetList.get(1).calculateXPosition(weatherPlanet.getDay()),
						planetList.get(1).calculateYPosition(weatherPlanet.getDay()),
						planetList.get(2).calculateXPosition(weatherPlanet.getDay()),
						planetList.get(2).calculateYPosition(weatherPlanet.getDay()));

				if (area > auxArea) {
					dayMaxRain = weatherPlanet.getDay();
				}
				auxArea = area;
			}
		}
		return dayMaxRain;
	}

	@Override
	public List<Period> findByWeather(WeatherEnum weatherEnum) {
		return periodRepository.findByWeather(weatherEnum);
	}

	@Override
	public void savePeriods(List<Period> periods) {
		periodRepository.saveAll(periods);
	}

	@Override
	public int countByPeriod(WeatherEnum weather) {
		return periodRepository.countByWeather(weather);
	}

	@Override
	public Period findByDay(int day) {
		return periodRepository.findByDay(day);
	}

}
