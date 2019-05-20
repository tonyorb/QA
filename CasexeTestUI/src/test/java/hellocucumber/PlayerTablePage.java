package hellocucumber;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayerTablePage {
	
	@FindBy(xpath = "//input[@name='PlayerSearch[login]']")
	private WebElement searchFieldByUserName;
		
	@FindBy(xpath = "//a[text()='Next >']")
	public WebElement nextButton;
	
	@FindBy(xpath = "//a[text()='Next >']")
	private List <WebElement> nextButtonList;
	
	@FindBy(xpath = "//span[@class='empty']")
	private List <WebElement> emptyTableList;
	
	@FindBy(xpath = "//tbody/tr")
	public List <WebElement> playersTableRows;

	public void searchByUserName(String text) {
		searchFieldByUserName.sendKeys(text);
		searchFieldByUserName.sendKeys(Keys.RETURN);
	}

	public boolean isNextButtonExist() {
		return nextButtonList.size()==0;
	}
	
	public boolean isEmpty() {
		return emptyTableList.size()>0;
	}
	public PlayerTablePage(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
