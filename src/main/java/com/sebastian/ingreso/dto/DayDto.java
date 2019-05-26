package com.sebastian.ingreso.dto;

import com.sebastian.ingreso.entity.Period;

public class DayDto {

	private int dia;
	private String clima;

	public DayDto(Period period) {
		super();
		this.dia = period.getDay();
		this.clima = period.getWeather().name();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

}
