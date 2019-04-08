package services.commands;

import java.util.Arrays;
import java.util.Scanner;

import enums.CharacterClass;
import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulateCharacterClass implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		CharacterClass charClass = null;

		while (charClass == null) {
			System.out.print("Enter in the character's class: ");
			final String charClassString =  scanner.next();

			if (Arrays.asList(CharacterClass.values()).stream().anyMatch(x -> x.toString().equals(charClassString))) {
				charClass = CharacterClass.valueOf(charClassString);
			}
			else {
				System.out.println("Invalid character class, please try again...");
			}
		}

		return playerBuilder.setCharacterClass(charClass);
	}
}
