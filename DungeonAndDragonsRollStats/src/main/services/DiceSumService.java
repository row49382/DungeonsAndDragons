package main.services;

import java.util.List;

public interface DiceSumService {
	int sumPercentileDiceRolls(List<Integer> rolls);
	default int sumDiceRolls(List<Integer> rolls) {
		return rolls.stream().reduce(0,  (x, y) -> x + y);
	}
}
