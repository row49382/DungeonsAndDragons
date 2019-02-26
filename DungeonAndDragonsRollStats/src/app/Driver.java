package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	private static final int STAT_ROLL_DICE_COUNT = 4;
	private static final int STAT_ROLL_DICE_NUNBER_OF_SIDES = 6;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String, Integer> statMap = createStatMap();
		
		printMenu();
		populateStatMap(statMap);
	}
	
	private static void populateStatMap(Map<String, Integer> statMap) {
		List<Integer> diceRollSums = new ArrayList<>(statMap.keySet().size() + 1);
		
		for (int setRoll = 0; setRoll < statMap.keySet().size() + 1; setRoll++) {
			diceRollSums.add((rollDice().stream().reduce(0, (x, y) -> x + y)));
		}
		
		int lowestSumRoll = getLowestRoll(diceRollSums);
		diceRollSums.remove(diceRollSums.indexOf(lowestSumRoll));
		
		System.out.println("Here are your rolls:");
		for (int i = 0; i < diceRollSums.size(); i++) {
			System.out.printf("%d) %d \n", i + 1, diceRollSums.get(i));
		}
	}
	
	private static List<Integer> rollDice() { 
		List<Integer> diceRolls = new ArrayList<>();
		Random randomRoll = new Random();
		
		for (int rolls = 0; rolls < STAT_ROLL_DICE_COUNT; rolls++) {
			diceRolls.add(randomRoll.nextInt(STAT_ROLL_DICE_NUNBER_OF_SIDES) + 1);
		}
		
		int lowestRoll = getLowestRoll(diceRolls);
		
		diceRolls.remove(diceRolls.indexOf(lowestRoll));
		return diceRolls;
	}
	
	private static void printMenu() {
		System.out.println("=== Dungeons and Dragons Dice Rolls ===");
	}
	
	private static int getLowestRoll(List<Integer> diceRolls) {
		int lowestRoll = diceRolls
				.stream()
				.reduce(diceRolls.stream().findFirst().get(), 
						(x, y) -> x > y ? y : x);
		
		return lowestRoll;
	}
	
	private static Map<String, Integer> createStatMap() {
		Map<String, Integer> statMap = new HashMap<String, Integer>();
		
		statMap.put("Strength", 0);
		statMap.put("Dexterity", 0);
		statMap.put("Intelligence", 0);
		statMap.put("Wisdom", 0);
		statMap.put("Charisma", 0);
		statMap.put("Constitution", 0);
		
		return statMap;
	}
}


