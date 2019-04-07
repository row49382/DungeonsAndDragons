package test.services.factories;

import main.services.DiceRollerService;
import main.services.DiceRollerServiceImpl;

public class DiceRollerServiceFactory {
	public static DiceRollerService createDiceRoller() {
		return new DiceRollerServiceImpl();
	}
}
