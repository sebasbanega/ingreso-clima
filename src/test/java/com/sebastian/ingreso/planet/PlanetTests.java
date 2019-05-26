package com.sebastian.ingreso.planet;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.sebastian.ingreso.entity.Planet;
import com.sebastian.ingreso.enums.ClockWiseEnum;

@RunWith(SpringRunner.class)
public class PlanetTests {

	Planet planet;

	@Before
	public void configurePlanet() {
		planet = new Planet();
		planet.setName("Ferengi");
		planet.setAngularVelocity(1);
		planet.setSunDistance(500d);
		planet.setWise(ClockWiseEnum.CLOCKWISE.getId());
	}

	@Test
	public void testPlanet() {
		assertNotNull(planet.calculateAngle(1));
	}

}
