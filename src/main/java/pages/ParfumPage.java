package pages;

import entities.ParfumEntity;
import enums.Filters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class ParfumPage extends DouglasPage {

	public ParfumPage(WebDriver driver) {
		super(driver);
	}

	public ParfumPage appyFilter(Filters filter, String value){
		closeModalDialog();

		if (!value.equalsIgnoreCase("")) {
			By xpathFilter = By.xpath(String.format("//div[contains(@class,'facet__title') and text()='%s']", filter.getFilterName()));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(webDriver -> ExpectedConditions.elementToBeClickable(xpathFilter).apply(webDriver)).click();

			By xpathFilterValue = By.xpath(String.format("//div[contains(@class,'facet-option__checkbox--rating-stars')]/div[contains(text(),'%s')]", value));
			wait.until(webDriver -> ExpectedConditions.elementToBeClickable(xpathFilterValue).apply(webDriver)).click();

			By xpathCloseButton = By.xpath("//button[contains(@class,'facet__close-button')]");
			wait.until(webDriver -> ExpectedConditions.elementToBeClickable(xpathCloseButton).apply(webDriver)).click();

			//Workaround - need change on waiting when progress circle will be invisible
			//Need help form devs because I cannot catch this element
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		return this;
	}

	private ArrayList<ParfumEntity> getParfumInfo(){
		ArrayList<ParfumEntity> parfums = new ArrayList<>();
		List<WebElement> prod = driver.findElements(By.xpath("//div[@data-testid = 'product-tile']"));

		for(int i=0; i < prod.size(); i++) {
			ParfumEntity parfum = new ParfumEntity();

			try {
				parfum.setTopBrand(prod.get(i).findElement(By.xpath(".//div[contains(@class,'top-brand')]")).getText());
			} catch (Exception ex) {
				parfum.setTopBrand("");
			}

			try {
			parfum.setBrandLine(prod.get(i).findElement(By.xpath(".//div[contains(@class,'brand-line')]")).getText());
			} catch (Exception ex) {
				parfum.setBrandLine("");
			}

			try {
			parfum.setName(prod.get(i).findElement(By.xpath(".//div[contains(@class,'name')]")).getText());
			} catch (Exception ex) {
				parfum.setName("");
			}

			try {
				parfum.setCategory(prod.get(i).findElement(By.xpath(".//div[contains(@class,'category')]")).getText());
			} catch (Exception ex) {
				parfum.setCategory("");
			}

			try {
				parfum.setPrice(prod.get(i).findElement(By.xpath(".//div[contains(@class,'price-row')]")).getText());
			} catch (Exception ex) {
				parfum.setPrice("");
			}

			try {
				parfum.setBasePrice(prod.get(i).findElement(By.xpath(".//div[contains(@class,'base-price-row')]")).getText());
			} catch (Exception ex) {
				parfum.setBasePrice("");
			}

			try {
				parfum.setRatingInfo(prod.get(i).findElement(By.xpath(".//span[@data-testid='ratings-info']")).getText());
			} catch (Exception ex) {
				parfum.setRatingInfo("");
			}

			parfums.add(parfum);
		}

		return parfums;
	}

	public ParfumPage printParfumInfo(){
		ArrayList<ParfumEntity> parfums = getParfumInfo();

		for (int i=0; i < parfums.size(); i++){
			System.out.println(
					String.format("#%d = Top brand: %s = Brand line: %s = Name: %s = Category: %s = Price: %s = Base price: %s = Rating info: %s",
							(i+1), parfums.get(i).getTopBrand(), parfums.get(i).getBrandLine(), parfums.get(i).getName(), parfums.get(i).getCategory(), parfums.get(i).getPrice(), parfums.get(i).getBasePrice(), parfums.get(i).getRatingInfo()));
		}

		return this;
	}
}
