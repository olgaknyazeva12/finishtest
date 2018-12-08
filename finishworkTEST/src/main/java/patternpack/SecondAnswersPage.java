package patternpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondAnswersPage{
	WebDriver driver;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement findButton;

	@FindBy(xpath = "(//a[@class='item__text'])[1]")
	public WebElement firstAnswer;

	public SecondAnswersPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public SecondAnswersPage() {

	}

	public void clickSearch() {
		findButton.click();

	}

	public boolean firstAnswerIsDisplayed() {
		return firstAnswer.isDisplayed();
	}
}
