package main.services;

import java.util.List;

public interface DiceSumService {
	default int sumDiceRolls(List<Integer> rolls) {
		return rolls.stream().reduce(0,  (x, y) -> x + y);
	}
}
