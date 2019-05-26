package com.sebastian.ingreso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sebastian.ingreso.enums.WeatherEnum;

@Entity
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer day;

	@Enumerated(EnumType.STRING)
	private WeatherEnum weather;
	
	public Period() {}

	public Period(Integer day, WeatherEnum weather) {
		this.day = day;
		this.weather = weather;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer days) {
		this.day = days;
	}

	public WeatherEnum getWeather() {
		return weather;
	}

	public void setWeather(WeatherEnum weather) {
		this.weather = weather;
	}

}
