package patternpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindAnswersPage extends SecondAnswersPage {
	WebDriver driver;
	String comparedTextForLiders = "здоровье";
	@FindBy(xpath = "//a[@data-name='answers']")
	public WebElement answersSearch;

	@FindBy(xpath = "//a[@title='Лидеры проекта']")
	public WebElement lidersSearch;

	@FindBy(xpath = "//div[text()='Лидеры по набранным баллам за неделю']")
	public WebElement comparedText;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement findButton;

	@FindBy(xpath = "//a[@data-tab='best']")
	public WebElement bestAnswers;

	@FindBy(xpath = "(//a[@class='item__text'])[1]")
	public WebElement firstAnswer;

	public FindAnswersPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public FindAnswersPage() {

	}

	public void clickAnswerSearch() {
		answersSearch.click();

	}

	public void clickAnswerBestSearch() {
		bestAnswers.click();

	}

	public void searchAnswer() {
		searchField.sendKeys(comparedTextForLiders);

	}

	public boolean methodsFromSecond() {
		super.clickSearch();
		return super.firstAnswerIsDisplayed();
	}

}
