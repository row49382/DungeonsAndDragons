package services.commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulateStartingLevel implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
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

		return playerBuilder.setStartingLevel(startingLevel);
	}
}
