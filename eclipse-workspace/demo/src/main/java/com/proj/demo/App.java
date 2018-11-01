package com.proj.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

/**
 * Hello world!
 *
 */
public class App {
	WebDriver driver;

	App(WebDriver driver) {
		this.driver = driver;
	}

	public void launch_url() {
		driver.get("https://google.com");
	}

	public void clickOnSearchIcon(String data) {
		WebElement searchfield=driver.findElement(By.id("lst-ib"));
		searchfield.sendKeys(data);
		searchfield.sendKeys(Keys.ENTER);
		

	}
}
