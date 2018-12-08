package patternpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactoryAnswer extends FindAnswersPage {
	WebDriver webdriver;
	@FindBy(xpath = "//a[@data-name='answers']")
	public String answersSearch;

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

	public FactoryAnswer(WebDriver driver) {

		PageFactory.initElements(webdriver, this);
	}

	public boolean factoryAnswerAll() {

		super.clickAnswerSearch();
		super.clickAnswerBestSearch();
		super.clickAnswerBestSearch();
		super.searchAnswer();
		return super.methodsFromSecond();
	}

}
