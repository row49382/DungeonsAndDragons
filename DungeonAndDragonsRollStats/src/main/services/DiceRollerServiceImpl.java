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
		
		List<Integer> diceRolls = new ArrayList<>();
		for (int rollCounter = 0; rollCounter < numberOfDice; rollCounter++) {
			diceRolls.add(this.randomRoller.nextInt(faceCount.getFaceCount()) + 1);
		}
		
		if (removeLowest) {
			diceRolls = this.removeLowestRoll(diceRolls);
		}
		
		return diceRolls;
	}

}
