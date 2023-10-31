package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import enums.TopMenuItems;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class DouglasPage {
	WebDriver driver;
	
	public DouglasPage(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@class, 'button__accept-all')]")
	WebElement btnAcceptCookies;
	
	@FindBy(id = "typeAhead-input")
	WebElement txtSearch;

	public DouglasPage acceptCookies(){
		try{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(webDriver -> ExpectedConditions.elementToBeClickable(btnAcceptCookies).apply(webDriver));
		btnAcceptCookies.click();
		} catch (Exception ex){
		}

		return this;
	}
	
	public DouglasPage selectMenuItem (TopMenuItems menu) {
		By xpathMenuItemParent = By.xpath(String.format("//nav//a[@type='nav-heading' and text()='%s']", menu.getParentMenuName()));
		WebElement menuItemParent = driver.findElement(xpathMenuItemParent);
		Actions actions = new Actions(driver);
		actions.moveToElement(menuItemParent);
		actions.perform();

		By xpathMenuItem = By.xpath(String.format("//a[contains(@class,'navigation-main__subcategory-link') and text()='%s']", menu.getChildMenuName()));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> ExpectedConditions.elementToBeClickable(xpathMenuItem).apply(webDriver)).click();

		closeModalDialog();

		return this;
	}

	public DouglasPage closeModalDialog(){
		try {
			By xpathCloseModal = By.xpath("//button[contains(@class,'survey-modal__close')]");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(webDriver -> ExpectedConditions.elementToBeClickable(xpathCloseModal).apply(webDriver)).click();
		} catch (Exception ex) {

		}

		return this;
	}

	public DouglasPage search(String searchCriteria) {
		txtSearch.sendKeys(searchCriteria + Keys.ENTER);
		
		return this;
	}

}
