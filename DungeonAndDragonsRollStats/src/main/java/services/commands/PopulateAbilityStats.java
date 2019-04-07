package services.commands;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import enums.Ability;
import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulateAbilityStats implements PlayerBuilderCommands {
	
	private List<Integer> diceRollSums;

	public PopulateAbilityStats(List<Integer> diceRollSums) {
		this.diceRollSums = diceRollSums;
	}
	
	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		Map<String, Integer> statMap = this.createAbilityStatMap();
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

		return playerBuilder.setAbilityStats(statMap);
	}

	private  Map<String, Integer> createAbilityStatMap() {
		Map<String, Integer> statMap = new HashMap<String, Integer>();

		statMap.put(Ability.Strength.toString(), 0);
		statMap.put(Ability.Dexterity.toString(), 0);
		statMap.put(Ability.Intelligence.toString(), 0);
		statMap.put(Ability.Wisdom.toString(), 0);
		statMap.put(Ability.Charisma.toString(), 0);
		statMap.put(Ability.Constitution.toString(), 0);

		return statMap;
	}

	private Map<String, Integer> getEmptyMapEntries(Map<String, Integer> map) {
		return map.entrySet()
				.stream()
				.filter(x -> x.getValue() == 0)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
	}
}
