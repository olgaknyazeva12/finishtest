package ngscenariopack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailSearchCafe {
	String searchCafe = "Cafe Minsk";
	@FindBy(xpath = "//input[@class='input search__input i-no-right-radius']")
	public WebElement searchField;

	@FindBy(xpath = "//input[@id='search:submit']")
	public WebElement searchButton;

	@FindBy(xpath = "//a[@class='light-link']")
	public List<WebElement> linksForCafe;

	@FindBy(xpath = "//input[@class='button big flat-white']")
	public WebElement assertElement;

	public MailSearchCafe(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void enterSearchText() {
		searchField.sendKeys(searchCafe);
	}

	public void clickElement() {
		searchButton.click();
	}



	public boolean elementIsDisplayed() {
		return linksForCafe.get(0).isDisplayed();
	}

}
