package main.services;

import java.util.ArrayList;
import java.util.List;

import main.enums.DiceFaceCount;

public interface DiceRollerService {
	List<Integer> rollDice(int numberOfDice, DiceFaceCount faceCount, boolean removeLowest) throws Exception;
	List<Integer> rollAdvantageOrDisadvantage(boolean hasAdvantage);
	List<Integer> rollPercentileDice();
	
	default List<Integer> removeLowestRoll(List<Integer> rolls) {
		int lowestRoll = rolls
				.stream()
				.reduce(rolls.get(0), 
						(x, y) -> x > y ? y : x);
		
		rolls.remove(rolls.indexOf(lowestRoll));
		return rolls;
	}
	
	default List<Integer> removeHighestRoll(List<Integer> rolls) {
		int highestRoll = rolls
				.stream()
				.reduce(rolls.get(0), 
						(x, y) -> x < y ? y : x);
		
		rolls.remove(rolls.indexOf(highestRoll));
		return rolls;
	}
}
