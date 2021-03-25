package sensorval;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest {
	@Test
	public void reportsErrorWhenSOCjumps() {
		Double[] readings = { 0.0, 0.01, 0.5, 0.51 };
		List<Double> socs = Arrays.asList(readings);
		assertFalse(SensorValidator.validateReadings(socs, 0.05));
	}

	@Test
	public void reportsErrorWhenCurrentjumps() {
		Double[] readings = { 0.03, 0.03, 0.03, 0.33 };
		List<Double> currents = Arrays.asList(readings);
		assertFalse(SensorValidator.validateReadings(currents, 0.1));
	}

	@Test
	public void reportsErrorWhenNull() {
		List<Double> currents = null;
		assertFalse(SensorValidator.validateReadings(currents, 0.1));
	}
}
