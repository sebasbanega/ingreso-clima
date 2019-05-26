package com.sebastian.ingreso;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.enums.ClockWiseEnum;
import com.sebastian.ingreso.service.weather.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngresoMeliApplicationTests {
	
	@Autowired
	private WeatherService weatherService;
	
	private Planet ferengi;
	private Planet betasoide;
	private Planet vulcano;
	
	protected List<Planet> planets;
	
	@Before
	public void preparePlanets() {
		planets = new ArrayList<>();

		/* configura el planeta Ferengi */
		ferengi = new Planet();
		ferengi.setName("Ferengi");
		ferengi.setWise(ClockWiseEnum.CLOCKWISE.getId());
		ferengi.setAngularVelocity(1);
		ferengi.setSunDistance(500d);
		ferengi.setDaysOfTheYear(360);
		/* agrega el planeta a la lista */
		planets.add(ferengi);
		
		/* configura el planeta Betasoide */
		betasoide = new Planet();
		betasoide.setName("Betasoide");
		betasoide.setWise(ClockWiseEnum.CLOCKWISE.getId());
		betasoide.setAngularVelocity(3);
		betasoide.setSunDistance(2000d);
		betasoide.setDaysOfTheYear(360/3);
		/* agrega el planeta a la lista */
		planets.add(betasoide);
		
		/* configura el planeta Vulcano */
		vulcano = new Planet();
		vulcano.setName("Vulcano");
		vulcano.setWise(ClockWiseEnum.COUNTER_CLOCKWISE.getId());
		vulcano.setAngularVelocity(5);
		vulcano.setSunDistance(1000d);
		vulcano.setDaysOfTheYear(360/5);
		/* agrega el planeta a la lista */
		planets.add(vulcano);
		
	}

	@Test
	public void contextLoads() {
		planets.add(betasoide);
		planets.add(ferengi);
		planets.add(vulcano);
		weatherService.calculatePeriodsByOrbit(planets, 10000);
	}

}
