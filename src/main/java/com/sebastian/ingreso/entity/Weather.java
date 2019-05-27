package com.sebastian.ingreso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sebastian.ingreso.enums.WeatherEnum;

@Entity
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer day;

	@Column
	private WeatherEnum wheather;

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public WeatherEnum getWheather() {
		return wheather;
	}

	public void setWheather(WeatherEnum wheather) {
		this.wheather = wheather;
	}

}
