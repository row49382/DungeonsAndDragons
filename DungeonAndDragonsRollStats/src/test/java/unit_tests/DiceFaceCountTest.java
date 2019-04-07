package unit_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enums.DiceFaceCount;

public class DiceFaceCountTest {

	@Test
	void testFourSidedFaceDiceFaceCountValue() {
		assertTrue(DiceFaceCount.FourSidedDice.getFaceCount() == 4);
	}
	
	@Test
	void testSixSidedFaceDiceFaceCountValue() {
		assertTrue(DiceFaceCount.SixSidedDice.getFaceCount() == 6);
	}
	
	@Test
	void testEightSidedFaceDiceFaceCountValue() {
		assertTrue(DiceFaceCount.EightSidedDice.getFaceCount() == 8);
	}
	
	@Test
	void testTenSidedFaceDiceFaceCountValue() {
		assertTrue(DiceFaceCount.TenSidedDice.getFaceCount() == 10);
	}
	
	@Test
	void testTwentySidedFaceDiceFaceCountValue() {
		assertTrue(DiceFaceCount.TwentySidedDice.getFaceCount() == 20);
	}

}
