package com.johnsontraining.protractor_selenium_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jprotractor.NgBy;
import com.jprotractor.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProtractorSeleniumExample {
	
	private WebDriver driver;
	private NgWebDriver ngDriver;
	private String baseUrl = "http://www.way2automation.com/angularjs-protractor/banking/#/login";
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		ngDriver = new NgWebDriver(driver);
		ngDriver.manage().window().maximize();
		ngDriver.get(baseUrl);
	}

	@Test
	public void loginAsCustomerTest() throws InterruptedException {
		
		ngDriver.findElement(NgBy.buttonText("Customer Login")).click();
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
		select.selectByVisibleText("Albus Dumbledore");
		Thread.sleep(3000);
		
		ngDriver.findElement(NgBy.buttonText("Login")).click();
	}
}
