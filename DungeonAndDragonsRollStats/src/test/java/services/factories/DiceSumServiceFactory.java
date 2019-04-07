package test.services.factories;

import main.services.DiceSumService;
import main.services.DiceSumServiceImpl;

public class DiceSumServiceFactory {
	public static DiceSumService createDiceSummer() {
		return new DiceSumServiceImpl();
	}
}
