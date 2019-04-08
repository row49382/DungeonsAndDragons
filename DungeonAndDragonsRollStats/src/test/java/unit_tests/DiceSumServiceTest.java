package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import enums.DiceFaceCount;
import services.DiceRollerService;
import services.DiceSumService;
import services.factories.DiceRollerServiceFactory;
import services.factories.DiceSumServiceFactory;

public class DiceSumServiceTest {

	@Test
	public void testSumRolls() throws Exception {
		DiceRollerService diceRoller = DiceRollerServiceFactory.createDiceRoller();
		DiceSumService diceSummer = DiceSumServiceFactory.createDiceSummer();
		
		List<Integer> rolls = diceRoller.rollDice(5, DiceFaceCount.EightSidedDice, false);
		int rollsSumFromDiceSummer = diceSummer.sumDiceRolls(rolls);
		
		int rollsSum = rolls.stream().reduce(0, (x, y) -> x + y);
		assertTrue(
				rollsSumFromDiceSummer == rollsSum, 
				String.format(
						"rolls sum service did not sum the dice rolls correctly. \nService sum was %d while derived sum was %d",
						rollsSumFromDiceSummer,
						rollsSum));
	}
	
	@Test
	public void testPercentileSum() {
		DiceSumService diceSummer = DiceSumServiceFactory.createDiceSummer();
		
		List<Integer> rolls = Arrays.asList(2, 7);
		int percentileSum = diceSummer.sumPercentileDiceRolls(rolls);
		
		assertTrue(percentileSum == 72);
	}
	
	@Test
	public void testPercentileSumDoubleZero() {
		DiceSumService diceSummer = DiceSumServiceFactory.createDiceSummer();
		
		List<Integer> rolls = Arrays.asList(0, 0);
		int percentileSum = diceSummer.sumPercentileDiceRolls(rolls);
		
		assertTrue(percentileSum == 100);
	}

}
