package main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.enums.DiceFaceCount;

public class DiceRollerServiceImpl implements DiceRollerService {
	private Random randomRoller;
	
	public DiceRollerServiceImpl() {
		this.randomRoller = new Random();
	}
	
	@Override
	public List<Integer> rollDice(int numberOfDice, DiceFaceCount faceCount, boolean removeLowest) throws Exception {
		if (numberOfDice < 0) {
			throw new Exception("number of dice to roll can not be negative.");
		}
		
		List<Integer> diceRolls = this.rollDice(numberOfDice, faceCount);
		return removeLowest ? this.removeLowestRoll(diceRolls) : diceRolls;
	}

	@Override
	public List<Integer> rollAdvantageOrDisadvantage(boolean hasAdvantage) {
		List<Integer> specialDiceRolls = this.rollDice(2, DiceFaceCount.TwentySidedDice);
		return hasAdvantage ? this.removeLowestRoll(specialDiceRolls) : this.removeHighestRoll(specialDiceRolls);
	}

	@Override
	public List<Integer> rollPercentileDice() {
		List<Integer> percentileRolls = new ArrayList<>();
		
		for (int rollCounter = 0; rollCounter < 2; rollCounter++) {
			percentileRolls.add(this.randomRoller.nextInt(9));
		}
		
		return percentileRolls;
	}
	
	/*
	 * Rolls the specified sided dice, the specified number of times
	 */
	private List<Integer> rollDice(int numberOfDice, DiceFaceCount faceCount) {
		List<Integer> diceRolls = new ArrayList<>();
		for (int rollCounter = 0; rollCounter < numberOfDice; rollCounter++) {
			diceRolls.add(this.randomRoller.nextInt(faceCount.getFaceCount()) + 1);
		}
		
		return diceRolls;
	}
	

}
