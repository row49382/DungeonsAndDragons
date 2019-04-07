package services.factories;

import services.DiceSumService;
import services.DiceSumServiceImpl;

public class DiceSumServiceFactory {
	public static DiceSumService createDiceSummer() {
		return new DiceSumServiceImpl();
	}
}
