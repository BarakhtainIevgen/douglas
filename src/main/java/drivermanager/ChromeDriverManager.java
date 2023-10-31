package drivermanager;

import enums.DriverType;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.ProjectData.browser;

public class ChromeDriverManager extends DriverManager {

		@Override
		public void createDriver() {
			ChromeOptions options = new ChromeOptions();

			if (browser == DriverType.CHROME_HEADLESS){
				System.out.println("Attention!!! Google Headless mode on!!!");
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1200");
				options.addArguments("--ignore-certificate-errors");
			}

			if(SystemUtils.IS_OS_LINUX) {
				options.addArguments("start-maximized"); 		 // open Browser in maximized mode
				options.addArguments("disable-infobars"); 		 // disabling infobars
				options.addArguments("--disable-extensions"); 	 // disabling extensions
				options.addArguments("--disable-gpu"); 			 // applicable to windows os only
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); 			 // Bypass OS security model
			}

			this.driver = new ChromeDriver(options);
		}
}
