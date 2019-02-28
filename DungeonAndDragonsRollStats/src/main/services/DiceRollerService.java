package main.services;

import java.util.List;

import main.enums.DiceFaceCount;

public interface DiceRollerService {
	List<Integer> rollDice(int numberOfDice, DiceFaceCount faceCount, boolean removeLowest) throws Exception;
	
	default List<Integer> removeLowestRoll(List<Integer> rolls) {
		int lowestRoll = rolls
				.stream()
				.reduce(rolls.get(0), 
						(x, y) -> x > y ? y : x);
		
		rolls.remove(rolls.indexOf(lowestRoll));
		return rolls;
	}
}
