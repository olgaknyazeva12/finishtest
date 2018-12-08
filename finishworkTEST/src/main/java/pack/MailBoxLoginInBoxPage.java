package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxLoginInBoxPage extends MailBoxCommonPage {
	WebDriver driver;

	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement emailField;

	@FindBy(xpath = "//*[@id='mailbox:submit']/input")
	private WebElement buttonEnter;

	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	public WebElement logoutLink;

	@FindBy(xpath = "//a[@id='PH_authLink']")
	public WebElement logoinLink;

	public MailBoxLoginInBoxPage(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void enterLoginAndPass() {
		loginField.clear();
		loginField.sendKeys(super.yourTestEmail);
		emailField.clear();
		emailField.sendKeys(super.yourTestPassword);
	}

	public void clickEnterButton() {
		buttonEnter.click();
	}

	public void clickLogoutButton() {
		logoutLink.click();
	}

	public boolean logoutIsDisplayed() {
		return logoutLink.isDisplayed();
	}

	public boolean loginIsDisplayed() {
		return logoinLink.isDisplayed();
	}

}
