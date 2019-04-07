package services.factories;

import services.DiceRollerService;
import services.DiceRollerServiceImpl;

public class DiceRollerServiceFactory {
	public static DiceRollerService createDiceRoller() {
		return new DiceRollerServiceImpl();
	}
}
