package com.sebastian.ingreso.dto;

public class ReportDto {

	private String key;
	private int count;

	public ReportDto(String key, int count) {
		super();
		this.key = key;
		this.count = count;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
