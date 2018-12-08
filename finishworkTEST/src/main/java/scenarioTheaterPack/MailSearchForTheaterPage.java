package scenarioTheaterPack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailSearchForTheaterPage {

	String searchTheater = "Theater afisha";
	@FindBy(xpath = "//input[@class='input search__input i-no-right-radius']")
	public WebElement searchField;

	@FindBy(xpath = "//input[@id='search:submit']")
	public WebElement searchButton;

	@FindBy(xpath = "//a[@class='light-link']")
	public List<WebElement> linksForTheater;

	@FindBy(xpath = "//input[@class='button big flat-white']")
	public WebElement assertElement;

	public MailSearchForTheaterPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void enterSearchText() {
		searchField.sendKeys(searchTheater);
	}

	public void clickElement() {
		searchButton.click();
	}

	public void clickLinkForCinema() {
		linksForTheater.get(0).click();
	}

	public boolean elementIsDisplayed() {
		return linksForTheater.get(0).isDisplayed();
	}

}
