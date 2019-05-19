package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageBase {
	class LoginPageS{
		WebElement loginField = Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_username']"));
		WebElement passwordField = Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_password']"));
		WebElement signInButton = Hooks.driver.findElement(By.xpath("//input[@value='Sing in']"));
	}
}
