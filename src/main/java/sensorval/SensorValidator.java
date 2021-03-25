package sensorval;

import java.util.List;

public class SensorValidator {
	private static boolean checkIfJumpExceedsMaxDelta(double value, double nextValue, double maxDelta) {
		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateReadings(List<Double> values, double maxDelta) {
		if (values == null)
			return false;

		return iterateAndCheckReadings(values, maxDelta);
	}

	private static boolean iterateAndCheckReadings(List<Double> values, double maxDelta) {
		int lastButOneIndex = values.size() - 1;
		for (int i = 0; i < lastButOneIndex; i++) {
			if (!checkIfJumpExceedsMaxDelta(values.get(i), values.get(i + 1), maxDelta)) {
				return false;
			}
		}
		return true;
	}
}
