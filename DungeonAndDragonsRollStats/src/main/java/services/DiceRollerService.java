package services;

import java.util.List;

import enums.DiceFaceCount;

public interface DiceRollerService {
	List<Integer> rollDice(int numberOfDice, DiceFaceCount faceCount, boolean removeLowest) throws Exception;
	List<Integer> rollAdvantageOrDisadvantage(boolean hasAdvantage);
	List<Integer> rollPercentileDice();
	
	default List<Integer> removeLowestRoll(List<Integer> rolls) {
		int lowestRoll = rolls
				.stream()
				.min((x, y) -> x.compareTo(y))
				.get();
		
		rolls.remove(rolls.indexOf(lowestRoll));
		return rolls;
	}
	
	default List<Integer> removeHighestRoll(List<Integer> rolls) {
		int highestRoll = rolls
				.stream()
				.max((x, y) -> x.compareTo(y))
				.get();
		
		rolls.remove(rolls.indexOf(highestRoll));
		return rolls;
	}
}
