package drivermanager;

import enums.DriverType;

public class DriverManagerFactory {
	public static DriverManager getDriverManager (DriverType type) {
		DriverManager driverManager = null;
		switch(type) {
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		
		default:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}
}
