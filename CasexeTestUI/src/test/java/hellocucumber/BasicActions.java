package hellocucumber;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions{
	LoginPage loginPage = new LoginPage(Hooks.driver);
	AdminPage adminPage = new AdminPage(Hooks.driver);
	PlayerTablePage playerTablePage = new PlayerTablePage(Hooks.driver);
	
	public void LogIn(String login, String password) {	
		loginPage.enterLogin(login).enterPassword(password).signIn();
	}
	public void OpenUrl(String url) {
    	Hooks.driver.get(url);
	}
	public String GetActualLogin() {
		return adminPage.getActualLogin();		
	}
	public int GetAdminPanelRowsCount() {
		return adminPage.adminPanelRows.size();
	}
	public void OpenPlayersList() {
		adminPage.selectUsers().selectPlayersInUsers();
	}
	public int GetPlayersTableRowCount() {
		return playerTablePage.playersTableRows.size();
	}
	public void SearchByUserName(String username) {
		playerTablePage.searchByUserName(username);
		WaitUntilAjaxComplite(Hooks.driver);
	}
	public void CheckSortByUserName (String text) {		
		while (true) {
			//количество игроков, в Username которых содержится заданный текст в любом регистре
			int playersWithGivenUserNameCount = Hooks.driver.findElements
												(By.xpath("//tbody/tr/td[2]/a[contains(translate(.," + 
												"'ABCDEFGHIJKLMNOPQRSTUVWXYZ'," + 
												"'abcdefghijklmnopqrstuvwxyz'), '" + 
												text+"')]")).size();
			int playersSummaryCount = GetPlayersTableRowCount();
			if (playersWithGivenUserNameCount==0&&playerTablePage.isEmpty()) {
				playersSummaryCount=0;
			}
			System.out.println(playersSummaryCount);
			System.out.println(playersWithGivenUserNameCount);
			assertEquals(playersSummaryCount, playersWithGivenUserNameCount);
			if (playerTablePage.isNextButtonExist() || !playerTablePage.nextButton.isDisplayed()){
				break;
			}
			playerTablePage.nextButton.click();
			WaitUntilAjaxComplite(Hooks.driver);
		}		
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
