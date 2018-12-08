package scenarioCinemaPack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailSearchForCinemaPage extends MailForAbstratcMethods {

	String searchCinema = "Afisha kino";
	@FindBy(xpath = "//input[@class='input search__input i-no-right-radius']")
	public WebElement searchField;

	@FindBy(xpath = "//input[@id='search:submit']")
	public WebElement searchButton;

	@FindBy(xpath = "//a[@class='light-link']")
	public List<WebElement> linksForCinema;

	@FindBy(xpath = "//input[@class='button big flat-white']")
	public WebElement assertElement;

	public MailSearchForCinemaPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void enterSearchText() {
		searchField.sendKeys(searchCinema);
	}

	public void clickElement() {
		searchButton.click();
	}

	public void clickLinkForCinema() {
		linksForCinema.get(0).click();
	}

	public boolean elementIsDisplayed() {
		return linksForCinema.get(0).isDisplayed();
	}

}
