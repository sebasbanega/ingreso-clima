package com.sebastian.ingreso.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.ingreso.dto.CompleteReportDto;
import com.sebastian.ingreso.dto.DayDto;
import com.sebastian.ingreso.dto.ReportDto;
import com.sebastian.ingreso.endpoint.WeatherEndpoint;
import com.sebastian.ingreso.entity.Period;
import com.sebastian.ingreso.enums.WeatherEnum;
import com.sebastian.ingreso.exception.PeriodNotFoundException;
import com.sebastian.ingreso.service.PeriodService;

@RestController
public class MainController {

	@Autowired
	private PeriodService periodService;

	@GetMapping(value = { WeatherEndpoint.BASE_URL })
	public DayDto viewDay(@RequestParam(value = "dia") int day) {
		Period period =  periodService.findByDay(day);
		if (period != null) {
			return new DayDto(period);
		} else {
			throw new PeriodNotFoundException();
		}
	}

	@GetMapping(value = { WeatherEndpoint.BASE_URL +  WeatherEndpoint.REPORT_URL})
	public CompleteReportDto report() {
		int droughtPeriods = periodService.countByPeriod(WeatherEnum.SEQUIA);
		int rainPeriods = periodService.countByPeriod(WeatherEnum.LLUVIA);
		int optimalPeriods = periodService.countByPeriod(WeatherEnum.OPTIMO);
		int dayMaxRain = periodService.maxDayByWeather(WeatherEnum.LLUVIA);

		List<ReportDto> results = Arrays.asList(new ReportDto(WeatherEnum.SEQUIA.name(), droughtPeriods),
				new ReportDto(WeatherEnum.LLUVIA.name(), rainPeriods),
				new ReportDto(WeatherEnum.OPTIMO.name(), optimalPeriods),
				new ReportDto("MAXIMO_DIA_DE_LLUVIA", dayMaxRain));

		String report = "períodos de sequía: " + droughtPeriods + "\n";
		report += "períodos de lluvia: " + rainPeriods + "\n";
		report += "períodos óptimos de temperatura y presión: " + optimalPeriods + "\n";
		report += "pico máximo de lluvia fue el día: " + dayMaxRain;

		CompleteReportDto completeReport = new CompleteReportDto(results, report);
		return completeReport;
	}

}
