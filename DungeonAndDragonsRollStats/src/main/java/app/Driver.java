package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import enums.Ability;
import enums.CharacterClass;
import enums.CharacterRace;
import enums.DiceFaceCount;
import models.Player;
import models.Player.PlayerBuilder;
import services.DiceRollerService;
import services.DiceRollerServiceImpl;
import services.DiceSumService;
import services.DiceSumServiceImpl;
import services.commands.PlayerBuilderCommands;
import services.commands.PopulateAbilityStats;
import services.commands.PopulateCharacterClass;
import services.commands.PopulateCharacterName;
import services.commands.PopulateCharacterRace;
import services.commands.PopulatePlayerName;
import services.commands.PopulateStartingLevel;

public class Driver {

	private static final int STAT_ROLL_DICE_COUNT = 4;
	private static final int ABILITY_COUNT = 6;
	
	public static void main(String[] args) throws Exception {
		DiceRollerService diceRoller = new DiceRollerServiceImpl();
		DiceSumService diceSummer = new DiceSumServiceImpl();
		List<Integer> diceRollSums = getDiceRollSums(diceRoller, diceSummer);
		
		// review order to make logical sense
		List<PlayerBuilderCommands> commandList = new ArrayList<>();
		commandList.add(new PopulatePlayerName());
		commandList.add(new PopulateCharacterName());
		commandList.add(new PopulateStartingLevel());
		commandList.add(new PopulateCharacterClass());
		commandList.add(new PopulateCharacterRace());
		commandList.add(new PopulateAbilityStats(diceRollSums));
		
		Invoker invoker = new Invoker(commandList, diceRollSums);
		
		invoker.start();
	}
	
	private static List<Integer> getDiceRollSums( 
			DiceRollerService diceRoller, 
			DiceSumService diceSummer) throws Exception {
		List<Integer> diceRollSums = new ArrayList<>(ABILITY_COUNT + 1);
		
		for (int setRoll = 0; setRoll < ABILITY_COUNT + 1; setRoll++) {
			List<Integer> diceRolls = diceRoller.rollDice(STAT_ROLL_DICE_COUNT, DiceFaceCount.SixSidedDice, true);
			diceRollSums.add(diceSummer.sumDiceRolls(diceRolls));
		}

		diceRollSums = diceRoller.removeLowestRoll(diceRollSums);
		
		return diceRollSums; 
	}
}

