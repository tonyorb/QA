package ru.gorbunov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage{

	static WebElement loginField = Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_username']"));
	static WebElement passwordField = Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_password']"));
	static WebElement signInButton = Hooks.driver.findElement(By.xpath("//input[@value='Sing in']"));

}
