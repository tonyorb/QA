package hellocucumber;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	@FindBy(xpath = "//li[@class='dropdown text-normal nav-profile']//span")
	private WebElement actualLogin;
	
	@FindBy(xpath = "//ul[@id='nav']/li")
	public List <WebElement> adminPanelRows;
	
	@FindBy(xpath = "//ul[@id='nav']/li/a/span[text()='Users']")
	private WebElement menuUsers;
	
	@FindBy(xpath = "//a[@href='/user/player/admin']")
	private WebElement usersPlayers;
	

	public AdminPage selectUsers() {
		menuUsers.click();
		return this;
	}
	public void selectPlayersInUsers() {
		usersPlayers.click();
	}
	public String getActualLogin() {
		return actualLogin.getText();
	}
	
	public AdminPage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
