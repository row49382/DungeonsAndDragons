package services.commands;

import java.util.Scanner;

import models.Player.PlayerBuilder;

@FunctionalInterface
public interface PlayerBuilderCommands {
	public PlayerBuilder setItem(PlayerBuilder playerBuilder, Scanner scanner);
}
