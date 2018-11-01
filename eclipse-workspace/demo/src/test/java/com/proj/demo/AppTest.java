package com.proj.demo;


import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
	WebDriver driver;
	App b;
	String data="Pipeline";
	@BeforeClass
	public void run1()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neha Kathuria\\Downloads\\chromedriver_win32\\chromedriver.exe");	

		driver=new ChromeDriver();
		b=new App(driver);
	}
	@Test
	public void Step01()
	{
		b.launch_url();
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"),"Successfully Launched");
	}
	@Test
	public void Step02()
	{
		b.clickOnSearchIcon(data);
		Assert.assertTrue(driver.getCurrentUrl().contains(data),"Search was successful.");
	}
}
