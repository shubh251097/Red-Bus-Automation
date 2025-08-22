package com.redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomationAssignment {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		System.out.println(driver.getTitle());

		By sourceButtonLocator = By.xpath("//div[contains(@class,\"srcDestWrapper\") and @role=\"button\"][1]");

		WebElement sourceButton = driver.findElement(sourceButtonLocator);
		sourceButton.click();

		Thread.sleep(4000);
		By searchSuggestionSectionLocator = By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSectionLocator));
		WebElement searchTextBoxElement = driver.switchTo().activeElement();
		searchTextBoxElement.sendKeys("Mumbai");

		By searchCategoryLocator = By.xpath("//div[contains(@class,\"searchCategory\")]");
		List<WebElement> searchList = wait
				.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator, 1));

		System.out.println(searchList.size());
		System.out.println(searchList.get(0));
	}

}
