package services.commands;

import java.util.Arrays;
import java.util.Scanner;

import enums.CharacterRace;
import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulateCharacterRace implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		System.out.print("Enter in the character's race: ");
		CharacterRace charRace = null;

		while (charRace == null) {
			final String charRaceString = scanner.next();

			if (Arrays.asList(CharacterRace.values()).stream().anyMatch(x -> x.toString().equals(charRaceString))) {
				charRace = CharacterRace.valueOf(charRaceString);
			}
			else {
				System.out.println("Invalid character race, please try again...");
			}
		}

		return playerBuilder.setCharacterRace(charRace);
	}
}
