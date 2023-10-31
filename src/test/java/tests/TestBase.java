package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import drivermanager.DriverManager;
import drivermanager.DriverManagerFactory;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;

import utils.ProjectData;
import utils.Utils;
import static utils.ProjectData.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	DriverManager driverManager;
	WebDriver driver;

	@BeforeSuite(alwaysRun=true)
	public void setTest(){
		switch(browser) {
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				ProjectData.browserPath = WebDriverManager.firefoxdriver().getDownloadedDriverPath();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				ProjectData.browserPath = WebDriverManager.chromedriver().getDownloadedDriverPath();
				break;
		}

	}

	@BeforeClass(alwaysRun=true)
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(browser);
		driver = driverManager.getDriver();		
		driver.manage().window().maximize();
		driver.get(appUrl);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown () {
		driverManager.quitDriver();
	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				System.out.println("Creating screenshot - start - " + Utils.getCurrentTime());

				String folder_name = System.getProperty("user.dir") + "/target/surefire-reports";
				File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				//Date format fot screenshot file name
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
				//create dir with given folder name
				new File(folder_name).mkdir();
				//Setting file name
				String file_name = df.format(new Date()) + ".png";
				//coppy screenshot file into screenshot folder.
				FileUtils.copyFile(f, new File(folder_name + "/" + file_name));

				System.out.println("Screenshot: " + folder_name + "/" + file_name);
				System.out.println("Creating screenshot - finish - " + Utils.getCurrentTime());
			} catch (Exception ex) {
				System.out.println("Something went wrong during creation screenshot. Screenshot not created.\n" + ex.getMessage());
			}
		}
	}
}
