package test.unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import main.enums.DiceFaceCount;
import main.services.DiceRollerService;
import test.services.factories.DiceRollerServiceFactory;

public class DiceRollerServiceTest {

	@Test
	public void testFourFaceDieRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.FourSidedDice, false);
		
		assertTrue(rolls.stream().allMatch(x -> x > 0 && x <= DiceFaceCount.FourSidedDice.getFaceCount()), 
				String.format("Values of four sided dice were not between 1 and %d", DiceFaceCount.FourSidedDice.getFaceCount()));
	}
	
	@Test
	public void testSixFaceDieRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.SixSidedDice, false);
		
		assertTrue(rolls.stream().allMatch(x -> x > 0 && x <= DiceFaceCount.SixSidedDice.getFaceCount()), 
				String.format("Values of six sided dice were not between 1 and %d", DiceFaceCount.SixSidedDice.getFaceCount()));
	}
	
	@Test
	public void testEightFaceDieRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.EightSidedDice, false);
		
		assertTrue(rolls.stream().allMatch(x -> x > 0 && x <= DiceFaceCount.EightSidedDice.getFaceCount()), 
				String.format("Values of eight sided dice were not between 1 and %d", DiceFaceCount.EightSidedDice.getFaceCount()));
	}
	
	@Test
	public void testTenFaceDieRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.TenSidedDice, false);
		
		assertTrue(rolls.stream().allMatch(x -> x > 0 && x <= DiceFaceCount.TenSidedDice.getFaceCount()), 
				String.format("Values of ten sided dice were not between 1 and %d", DiceFaceCount.TenSidedDice.getFaceCount()));
	}
	
	@Test
	public void testTwentyFaceDieRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.TwentySidedDice, false);
		
		assertTrue(rolls.stream().allMatch(x -> x > 0 && x <= DiceFaceCount.TwentySidedDice.getFaceCount()), 
				String.format("Values of twenty sided dice were not between 1 and %d", DiceFaceCount.TwentySidedDice.getFaceCount()));
	}
	
	@Test
	public void testRemoveLowestRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(1, DiceFaceCount.FourSidedDice, false);
		
		int lowestRoll = this.getLowestRoll(rolls);
		
		// incase multiple instances of the lowest number exist, verify count after removal
		// is one less than before the removal
		int lowestRollCount = this.countIf(rolls, x -> x == lowestRoll);
		
		rolls = diceRoller.removeLowestRoll(rolls);
		int lowestRollCountAfterRemovingRoll = this.countIf(rolls, x -> x == lowestRoll);
		
		assertTrue(lowestRollCount == (lowestRollCountAfterRemovingRoll + 1),
				"Lowest roll was not removed from the dice rolls");
	}
	
	@Test
	public void testNumberOfDiceRoll() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollDice(4, DiceFaceCount.FourSidedDice, false);
		
		assertTrue(rolls.size() == 4);
	}
	
	@Test
	public void testNegativeNumberOfDiceRoll() {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		
		assertThrows(Exception.class, () -> {
			List<Integer> rolls = diceRoller.rollDice(-1, DiceFaceCount.FourSidedDice, false);
		}, 
		"dice roller did not throw exception when number of dice rolled was negative.");
		
	}
	
	@Test
	public void testPercentileDiceRollValueRange() {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollPercentileDice();
		
		assertTrue(rolls.stream().allMatch(x -> x >= 0 && x < 10), 
				"Values for percentile roll were not in range 0 - 9");
	}
	
	@Test
	public void testPercentileDiceRollCount() {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		List<Integer> rolls = diceRoller.rollPercentileDice();
		
		assertTrue(rolls.size() == 2);
	}
	
	private int getLowestRoll(List<Integer> rolls) {
		return rolls
				.stream()
				.reduce(rolls.get(0), (x, y) -> x > y ? y : x);
	}
	
	private int countIf(List<Integer> rolls, Predicate<? super Integer> predicate) {
		return (int)rolls
		.stream()
		.filter(predicate)
		.count();
	}

}
