package sensorval;

import java.util.List;

public class SensorValidator {
	public static boolean checkIfDiffValuesExceedsMaxDelta(double value, double nextValue, double maxDelta) {
		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateReadings(List<Double> values, double maxDelta) {
		if (values == null)
			return false;
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!checkIfDiffValuesExceedsMaxDelta(values.get(i), values.get(i + 1), maxDelta)) {
				return false;
			}
		}
		return true;
	}
}
