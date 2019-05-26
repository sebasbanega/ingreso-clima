package com.sebastian.ingreso.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sebastian.ingreso.enums.ClockWiseEnum;
import com.sebastian.ingreso.util.MathUtil;

@Entity
@Table(name = "planeta")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private Integer angularVelocity;

	@NotEmpty
	private int wise;

	@NotEmpty
	private Double sunDistance;

	@Column
	private Integer daysOfTheYear;

	public Double calculateAngle(int day) {
		Integer degrees = 0;
		Integer auxDay = new Integer(day);
		if (auxDay > this.daysOfTheYear) {
			auxDay = MathUtil.restYearsFromDays(auxDay, this.daysOfTheYear);
		}
		degrees = auxDay * this.angularVelocity;
		if (this.wise == ClockWiseEnum.COUNTER_CLOCKWISE.getId()) {
			degrees = 360 - degrees;
		}
		return Math.toRadians(degrees);
	}

	public Double calculateXPosition(Integer day) {
		Double xPositions = 0D;
		xPositions = new BigDecimal(this.sunDistance * Math.cos(this.calculateAngle(day)))
				.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		return xPositions;
	}

	public Double calculateYPosition(Integer day) {
		Double yPositions = 0D;
		yPositions = new BigDecimal(this.sunDistance * Math.sin(this.calculateAngle(day)))
				.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		return yPositions;
	}

	/* getters && setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAngularVelocity() {
		return angularVelocity;
	}

	public void setAngularVelocity(Integer angularVelocity) {
		this.angularVelocity = angularVelocity;
	}

	public Integer getDaysOfTheYear() {
		return daysOfTheYear;
	}

	public void setDaysOfTheYear(Integer daysOfTheYear) {
		this.daysOfTheYear = daysOfTheYear;
	}

	public int getWise() {
		return wise;
	}

	public void setWise(int wise) {
		this.wise = wise;
	}

	public Double getSunDistance() {
		return sunDistance;
	}

	public void setSunDistance(Double sunDistance) {
		this.sunDistance = sunDistance;
	}

}
