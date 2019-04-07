package app;

import java.util.List;
import java.util.Scanner;

import services.commands.PlayerBuilderCommands;
import models.Player;
import models.Player.PlayerBuilder;

public class Invoker {
	
	private final List<PlayerBuilderCommands> commandList;
	private final List<Integer> diceRollSums;
	
	public Invoker(List<PlayerBuilderCommands> commandList, List<Integer> diceRollSums) {
		this.commandList = commandList;
		this.diceRollSums = diceRollSums;
	}
	
	public void start() {
		PlayerBuilder playerBuilder = new PlayerBuilder();
		Scanner scanner = new Scanner(System.in);
		
		this.printMenu();
		this.printDiceRolls();
		
		for (PlayerBuilderCommands command: commandList) {
			playerBuilder = command.setItem(playerBuilder, scanner);
		}
		
		Player player = playerBuilder.build();
		
		this.printCreatedPlayer(player);
	}
	
	private void printMenu() {
		System.out.println("=== Dungeons and Dragons Dice Rolls ===");
	}
	
	private void printCreatedPlayer(Player player) {
		System.out.println("The following player was created: ");
		System.out.println(player);
	}
	
	private void printDiceRolls() {
		System.out.println("Here are your rolls:");
		for (int i = 0; i < diceRollSums.size(); i++) {
			System.out.printf("%d \n", diceRollSums.get(i));
		}
	}
}
