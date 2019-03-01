package main.services;

import java.util.List;

public class DiceSumServiceImpl implements DiceSumService {
	public int sumPercentileDiceRolls(List<Integer> percentileRolls) {
		int percentileValue = 0;
		
		if (percentileRolls.stream().allMatch(x -> x == 0)) {
			percentileValue = 100;
		}
		else {
			for (int rollCounter = 0; rollCounter < percentileRolls.size(); rollCounter++) {
				percentileValue += (Math.pow(10, rollCounter) * percentileRolls.get(rollCounter));
			}
		}
		
		return percentileValue;
	}
}
