package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mail {
	WebDriver webdriver;

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

	public void print() {
		System.out.println("Class Mail is run successfully!");
	}
}
