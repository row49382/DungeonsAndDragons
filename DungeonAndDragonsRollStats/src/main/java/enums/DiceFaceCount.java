package main.enums;

public enum DiceFaceCount {
	FourSidedDice(4),
	SixSidedDice(6),
	EightSidedDice(8),
	TenSidedDice(10),
	TwentySidedDice(20);
	
	private int faceCount;
	
	private DiceFaceCount(int faceCount) {
		this.faceCount = faceCount;
	}
	
	public int getFaceCount() {
		return this.faceCount;
	}
}
