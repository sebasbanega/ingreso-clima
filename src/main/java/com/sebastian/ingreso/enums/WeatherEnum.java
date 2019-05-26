package com.sebastian.ingreso.enums;

public enum WeatherEnum {

	SEQUIA(1), LLUVIA(2), OPTIMO(3), NORMAL(4);

	int id;

	WeatherEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
