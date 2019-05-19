package ru.gorbunov;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	public static WebDriver driver;

	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/ru.gorbunov/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@After
	public static void tearDown() {
	    driver.close();
	}
}