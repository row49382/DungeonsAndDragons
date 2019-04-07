package main.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import main.enums.Ability;
import main.enums.CharacterClass;
import main.enums.CharacterRace;
import main.enums.DiceFaceCount;
import main.models.Player;
import main.models.Player.PlayerBuilder;
import main.services.DiceRollerService;
import main.services.DiceRollerServiceImpl;
import main.services.DiceSumService;
import main.services.DiceSumServiceImpl;

public class Driver {

	private static final int STAT_ROLL_DICE_COUNT = 4;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String, Integer> abilityStatMap = createAbilityStatMap();
		DiceRollerService diceRoller = new DiceRollerServiceImpl();
		DiceSumService diceSummer = new DiceSumServiceImpl();
		PlayerBuilder newPlayerBuilder = new PlayerBuilder();
		
		printMenu();
		List<Integer> diceRollSums = getDiceRollSums(abilityStatMap, diceRoller, diceSummer);
		
		Player player = newPlayerBuilder
				.setPlayerName(populatePlayerName(input))
				.setCharacterName(populateCharacterName(input))
				.setCharacterClass(populateCharacterClass(input))
				.setCharacterRace(populateCharacterRace(input))
				.setStartingLevel(populateStartingLevel(input))
				.setAbilityStats(populateAbilityStatMap(input, abilityStatMap, diceRollSums))
				.build();
		
		System.out.println("The following player was created: ");
		System.out.println(player);
	}
	
	private static CharacterRace populateCharacterRace(Scanner scanner) {
		System.out.print("Enter in the character's race: ");
		CharacterRace charClass = null;
		
		while (charClass == null) {
			final String charRaceString = scanner.next();
			
			if (Arrays.asList(CharacterRace.values()).stream().anyMatch(x -> x.toString().equals(charRaceString))) {
				charClass = CharacterRace.valueOf(charRaceString);
			}
			else {
				System.out.println("Invalid character race, please try again...");
			}
		}
		
		return charClass;
	}

	private static int populateStartingLevel(Scanner scanner) {
		System.out.print("Enter in the character's starting level: ");
		int startingLevel = -1;
		
		while (startingLevel == - 1) {
			try {
				startingLevel = scanner.nextInt();
				scanner.nextLine();
			}
			catch (InputMismatchException ime) {
				System.out.println("Invalid starting level, please try again...");
			}
		}
		
		return startingLevel;
	}

	private static String populatePlayerName(Scanner scanner) {
		System.out.print("Enter in the player's name: ");
		return scanner.nextLine();
	}

	private static CharacterClass populateCharacterClass(Scanner scanner) {
		System.out.print("Enter in the character's class: ");
		CharacterClass charClass = null;
		
		while (charClass == null) {
			final String charClassString =  scanner.next();
			
			if (Arrays.asList(CharacterClass.values()).stream().anyMatch(x -> x.toString().equals(charClassString))) {
				charClass = CharacterClass.valueOf(charClassString);
			}
			else {
				System.out.println("Invalid character class, please try again...");
			}
		}
		
		return charClass;
	}

	private static String populateCharacterName(Scanner scanner) {
		System.out.print("Enter in the character's name: ");
		return scanner.nextLine();
	}

	private static List<Integer> getDiceRollSums(
			Map<String, Integer> statMap, 
			DiceRollerService diceRoller, 
			DiceSumService diceSummer) {
		List<Integer> diceRollSums = new ArrayList<>(statMap.keySet().size() + 1);
		
		for (int setRoll = 0; setRoll < statMap.keySet().size() + 1; setRoll++) {
			List<Integer> diceRolls = null;
			
			// catches case if the number of dice rolled is negative
			while (diceRolls == null) {
				try {
					diceRolls = diceRoller.rollDice(STAT_ROLL_DICE_COUNT, DiceFaceCount.SixSidedDice, true);
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			diceRollSums.add(diceSummer.sumDiceRolls(diceRolls));
		}

		diceRollSums = diceRoller.removeLowestRoll(diceRollSums);
		
		System.out.println("Here are your rolls:");
		for (int i = 0; i < diceRollSums.size(); i++) {
			System.out.printf("%d \n", diceRollSums.get(i));
		}
		
		return diceRollSums; 
	}
	
	private static Map<String, Integer> populateAbilityStatMap(
			Scanner scanner, 
			Map<String, Integer> statMap, 
			List<Integer> diceRollSums) {
		
		Map<String, Integer> emptyMapAbilityStats = getEmptyMapEntries(statMap);
		
		while (emptyMapAbilityStats.entrySet().size() > 0) {
			
			System.out.println("Enter the ability you want to add a value to");
			System.out.println("The following abilities without values are:");
			
			for (String ability: emptyMapAbilityStats.keySet()) {
				System.out.printf("%s\n", ability);
			}
			
			String abilityOption = scanner.next();
			
			if (statMap.keySet().stream().anyMatch(x -> x.equals(abilityOption))) {
				System.out.printf("Enter value for ability %s \n", abilityOption);
				System.out.println("The remaining values are:");
				for (int sumRoll: diceRollSums) {
					System.out.printf("%s\n", sumRoll);
				}
				
				int diceRoll = -1;
				
				while (diceRoll == -1) {
					try {
						diceRoll = scanner.nextInt();
						scanner.nextLine();
					}
					catch (InputMismatchException ime) {
						System.out.println("Value entered wasn't an integer, please try again.");
					}
				}
				
				final int checkRoll = diceRoll;
				if (diceRollSums.stream().anyMatch(x -> x == checkRoll)) {
					statMap.put(abilityOption, diceRoll);
					
					diceRollSums.remove(diceRollSums.indexOf(diceRoll));
					emptyMapAbilityStats = getEmptyMapEntries(statMap);
				}
				else {
					System.out.println("Sum roll did not match, please try again...");
				}
			}
			else {
				System.out.println("Ability did not match, please try again...");
			}
		}
		
		return statMap;
	}
	
	private static void printMenu() {
		System.out.println("=== Dungeons and Dragons Dice Rolls ===");
	}
	
	private static Map<String, Integer> getEmptyMapEntries(Map<String, Integer> map) {
		return map.entrySet()
		.stream()
		.filter(x -> x.getValue() == 0)
		.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}
	
	private static Map<String, Integer> createAbilityStatMap() {
		Map<String, Integer> statMap = new HashMap<String, Integer>();
		
		statMap.put(Ability.Strength.toString(), 0);
		statMap.put(Ability.Dexterity.toString(), 0);
		statMap.put(Ability.Intelligence.toString(), 0);
		statMap.put(Ability.Wisdom.toString(), 0);
		statMap.put(Ability.Charisma.toString(), 0);
		statMap.put(Ability.Constitution.toString(), 0);
		
		return statMap;
	}
}


