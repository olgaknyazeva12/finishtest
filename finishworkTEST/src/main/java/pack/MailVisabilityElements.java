package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailVisabilityElements {

	@FindBy(xpath = "//div//h3[text()='ICQ']")
	private WebElement icqElement;

	@FindBy(xpath = "//div//h3[text()='Мой Мир']")
	private WebElement myWorldElement;

	@FindBy(xpath = "//div//h3[text()='Одноклассники']")
	private WebElement classmatesElement;

	@FindBy(xpath = "//div//h3[text()='Агент Mail.Ru']")
	private WebElement mailRuElement;

	@FindBy(xpath = "//div//h3[text()='Гороскопы']")
	private WebElement horoscopeElement;

	@FindBy(xpath = "//div//h3[text()='ТВ-программа']")
	private WebElement tvProgramElement;

	@FindBy(xpath = "//div//h3[text()='Товары']")
	private WebElement itemsElement;
	
	@FindBy(xpath = "//input[@value='Найти']")
	private WebElement findButtonElement;
	
	public MailVisabilityElements(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public boolean elementIsDisplayed() {
		return (icqElement.isDisplayed() && myWorldElement.isDisplayed() && classmatesElement.isDisplayed()
				&& mailRuElement.isDisplayed() && horoscopeElement.isDisplayed() && tvProgramElement.isDisplayed()
				&& itemsElement.isDisplayed());
	}
	
	public String elementTextIsDisplayed(WebElement element) {
		return findButtonElement.toString();
	}
	
	

}
