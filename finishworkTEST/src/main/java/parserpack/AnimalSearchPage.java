package parserpack;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

public class AnimalSearchPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@data-name='pictures']")
	public WebElement puctureSearch;

	@FindBy(xpath = "//a[@data-name='video']")
	public WebElement videoSearch;

	@FindBy(xpath = "//a[@data-name='apps']")
	public WebElement appSearch;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement findButton;

	@FindBy(xpath = "(//div[@class='images-item__border'])[1]")
	public WebElement firstPicture;

	@FindBy(xpath = "(//div[@class='video-item__thumb-wrap'])[1]")
	public WebElement firstVideo;

	@FindBy(xpath = "(//a[@class='appstop__link'])[1]")
	public WebElement firstApp;

	public AnimalSearchPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void clickPictureSearch() {
		puctureSearch.click();

	}

	public void clickVideoSearch() {
		videoSearch.click();

	}

	public void clickAppSearch() {
		appSearch.click();

	}

	public void clickFindButton() {
		findButton.click();

	}

	public boolean firstSearchPictureIsDisplayed() {
		return firstPicture.isDisplayed();
	}

	public boolean firstSearchVideoIsDisplayed() {
		return firstVideo.isDisplayed();
	}

	public boolean firstSearchAppIsDisplayed() {
		return firstApp.isDisplayed();
	}

	public void enterPictureNameSax()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		AnimalParserMethods name = new AnimalParserMethods();
		searchField.sendKeys(name.saxMethod());
	}

	public void enterVideoNameStax()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		AnimalParserMethods name = new AnimalParserMethods();
		searchField.sendKeys(name.staxMethod());
	}

	public void enterAppNameDom() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		AnimalParserMethods name = new AnimalParserMethods();
		searchField.sendKeys(name.domMethod());
	}

}
