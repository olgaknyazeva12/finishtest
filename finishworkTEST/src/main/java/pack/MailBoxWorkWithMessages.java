package pack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxWorkWithMessages extends Mail {

	WebDriver driver;

	@FindBy(xpath = ".//div[@class='js-item-checkbox b-datalist__item__cbx']")
	public List<WebElement> checkBoxes;

	@FindBy(xpath = ".//div[@data-name='spam']")
	private WebElement spamButton;

	@FindBy(xpath = ".//div[@data-name='noSpam']")
	private WebElement notSpamButton;

	@FindBy(xpath = "(//span[@class='b-datalist__empty__text'])[2]")
	private WebElement assertTextNoMessages;

	@FindBy(xpath = "//span[text()='В вашей почте спама нет!']")
	private WebElement assertTextNoSpam;

	@FindBy(xpath = "(//span[@class='b-nav__item__text'])[4]")
	private WebElement spamMenuOption;

	@FindBy(xpath = "(.//div[@data-name='remove'])[1]")
	private WebElement removeButton;

	@FindBy(xpath = "(//span[@class='b-nav__item__text'])[5]")
	private WebElement trashMenuOption;

	@FindBy(xpath = "(//div[@class='b-dropdown__ctrl js-shortcut'])[5]")
	private WebElement changePlaceDropdown;

	@FindBy(xpath = "//a[@data-text='Входящие']")
	private WebElement yourMessages;

	@FindBy(xpath = "(//div[@class='js-widget b-folder-promo__item b-folder-promo__default'])[2]")
	private WebElement assertTextNotInTrash;

	@FindBy(xpath = "(//div[@class='b-checkbox__box'])[2]")
	private WebElement checkAllMessages;

	@FindBy(xpath = "(//div[@data-name='flagged'])[1]")
	private WebElement checkFlag;

	@FindBy(xpath = "//div[@data-bem='b-flag']")
	private List<WebElement> addFlag;

	@FindBy(xpath = "(//span[@class='b-datalist__empty__text'])[2]")
	private WebElement assertNotFlag;

	@FindBy(xpath = "(//div[@data-mnemo='ctrl'])[6]")
	private WebElement more;

	@FindBy(xpath = "//a[@data-name='flag_no']")
	private WebElement noFlag;

	@FindBy(xpath = "	(//span[@class='b-datalist__empty__text'])[2]")
	private WebElement assertForRemovedMessages;

	public MailBoxWorkWithMessages(WebDriver webdriver) {
		PageFactory.initElements(webdriver, this);
	}

	public void addAllMessagesInSpam() {

		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		spamButton.click();

	}

	public void removeAllMessagesFromSpam() {
		spamMenuOption.click();
		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		notSpamButton.click();

	}

	public boolean checkMessagesInSpam() {
		return assertTextNoMessages.isDisplayed();
	}

	public boolean checkMessagesRemovedFromSpam() {
		return assertTextNoSpam.isDisplayed();
	}

	public boolean addAllMessagesInTrash() {

		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		removeButton.click();
		return assertForRemovedMessages.isDisplayed();

	}

	public void addFlagToMessages() {

		for (int i = 0; i < checkBoxes.size(); i++) {
			addFlag.get(i).click();
		}
		checkFlag.click();
	}

	public boolean removeFromFlag() {
		for (int i = 0; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		more.click();
		noFlag.click();
		checkFlag.click();
		return assertNotFlag.isDisplayed();
	}

}
