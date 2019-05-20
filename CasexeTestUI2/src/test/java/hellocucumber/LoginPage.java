package hellocucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

	@FindBy(id = "UserLogin_username")
	private WebElement loginfield;
	
	@FindBy(id = "UserLogin_password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signInButton;

	public LoginPage enterLogin(String login) {
		loginfield.sendKeys(login);
		return this;
	}
	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	public void signIn() {
		signInButton.click();
	}
	public LoginPage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
