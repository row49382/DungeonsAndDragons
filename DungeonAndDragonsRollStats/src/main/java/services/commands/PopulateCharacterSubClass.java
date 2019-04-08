package services.commands;

import java.util.Arrays;
import java.util.Scanner;

import enums.CharacterSubClass;
import models.Player.PlayerBuilder;

public class PopulateCharacterSubClass implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		
		if (playerBuilder.getCharacterClass().getSubClasses().isEmpty()) {
			return playerBuilder;
		}
		
		System.out.println(String.format("For class %s here are the valid sub classes", playerBuilder.getCharacterClass()));

		for (CharacterSubClass subClass: playerBuilder.getCharacterClass().getSubClasses()) {
			System.out.printf("- %s \n", subClass.toString());
		}

		CharacterSubClass charSubClass = null;

		while (charSubClass == null) {
			System.out.print("Enter a sub class listed above: ");

			final String charSubClassString = scanner.next();
			scanner.nextLine();

			if (Arrays.asList(CharacterSubClass.values()).stream().anyMatch(x -> x.toString().equals(charSubClassString))) {
				charSubClass = CharacterSubClass.valueOf(charSubClassString);
			}
			else {
				System.out.printf("Invalid character sub class for class %s, please try again...\n", playerBuilder.getCharacterClass());
			}
		}
		
		return playerBuilder.setCharacterSubClass(charSubClass);
	}
}
