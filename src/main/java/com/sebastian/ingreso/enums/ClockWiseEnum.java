package com.sebastian.ingreso.enums;

public enum ClockWiseEnum {
	
	CLOCKWISE(1),
	
	COUNTER_CLOCKWISE(2);
	
	int id;
	
	ClockWiseEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	
}
