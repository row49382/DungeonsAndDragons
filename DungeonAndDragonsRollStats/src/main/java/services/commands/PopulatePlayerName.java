package services.commands;

import java.util.Scanner;

import services.commands.PlayerBuilderCommands;
import models.Player.PlayerBuilder;

public class PopulatePlayerName implements PlayerBuilderCommands {

	@Override
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner) {
		System.out.print("Enter in the player's name: ");
		return playerBuilder.setPlayerName(scanner.nextLine());
	}
}
