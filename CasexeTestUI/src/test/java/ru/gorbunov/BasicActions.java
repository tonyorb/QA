package ru.gorbunov;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions extends PageBase{
	public void LogIn(String login, String password) {		
		Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_username']")).sendKeys(login);
		Hooks.driver.findElement(By.xpath("//input[@id='UserLogin_password']")).sendKeys(password);
		Hooks.driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	}
	public void OpenUrl(String url) {
    	Hooks.driver.get(url);
	}
	public String GetActualLogin() {
		return Hooks.driver.findElement(By.xpath("//li[@class='dropdown text-normal nav-profile']//span")).getText();		
	}
	public int GetAdminPanelRowsCount() {
		return Hooks.driver.findElements(By.xpath("//ul[@id='nav']/li")).size();
	}
	public void OpenPlayersList() {
		Hooks.driver.findElement(By.xpath("//ul[@id='nav']/li/a/span[text()='Users']")).click();
		Hooks.driver.findElement(By.xpath("//a[@href='/user/player/admin']")).click();
	}
	public int GetPlayersTableRowCount() {
		return Hooks.driver.findElements(By.xpath("//tbody/tr")).size();
	}
	public void SearchByUserName(String username) {
		WebElement searchField = Hooks.driver.findElement(By.xpath("//input[@name='PlayerSearch[login]']"));
		searchField.sendKeys(username);
		searchField.sendKeys(Keys.RETURN);
		WaitUntilAjaxComplite(Hooks.driver);
	}
	public void WaitUntilAjaxComplite(WebDriver driver) {
		new WebDriverWait(driver, 2000).until(new ExpectedCondition<Boolean>() {
			  public Boolean apply(WebDriver driver) {
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    return (Boolean) js.executeScript("return jQuery.active == 0");
			  }
			});
	}
}
