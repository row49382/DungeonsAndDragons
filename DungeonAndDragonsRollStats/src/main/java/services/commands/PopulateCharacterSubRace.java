package services.commands;

import java.util.Arrays;
import java.util.Scanner;

import enums.CharacterRace;
import enums.CharacterSubRace;
import models.Player.PlayerBuilder;

public class PopulateCharacterSubRace implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		
		if (playerBuilder.getCharacterRace().getSubRaces().isEmpty()) {
			return playerBuilder.setCharacterSubRace(CharacterSubRace.Not_Applicable);
		}
		
		this.printCharacterSubRacePrompt(playerBuilder);
		
		CharacterSubRace charSubRace = this.selectCharacterSubRace(scanner, playerBuilder.getCharacterRace());
		
		return playerBuilder.setCharacterSubRace(charSubRace);
	}
	
	private void printCharacterSubRacePrompt(PlayerBuilder playerBuilder) {
		System.out.println(String.format("For race %s here are the valid sub races:", playerBuilder.getCharacterRace()));

		for (CharacterSubRace subRace: playerBuilder.getCharacterRace().getSubRaces()) {
			System.out.printf("- %s \n", subRace.toString());
		}
	}
	
	private CharacterSubRace selectCharacterSubRace(Scanner scanner, CharacterRace characterRace) {
		CharacterSubRace charSubRace = null;

		while (charSubRace == null) {
			System.out.print("Enter a sub race listed above: ");

			final String charSubRaceString = scanner.next();
			scanner.nextLine();

			if (Arrays.asList(CharacterSubRace.values()).stream().anyMatch(x -> x.toString().equals(charSubRaceString))) {
				charSubRace = CharacterSubRace.valueOf(charSubRaceString);
			}
			else {
				System.out.printf("Invalid character sub race for race %s, please try again...\n", characterRace);
			}
		}
		
		return charSubRace;
	}
}
