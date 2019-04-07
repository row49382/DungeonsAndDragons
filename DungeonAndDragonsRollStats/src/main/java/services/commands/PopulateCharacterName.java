package services.commands;

import java.util.Scanner;

import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulateCharacterName implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		System.out.print("Enter in the character's name: ");
		return playerBuilder.setCharacterName(scanner.nextLine());
	}

}
