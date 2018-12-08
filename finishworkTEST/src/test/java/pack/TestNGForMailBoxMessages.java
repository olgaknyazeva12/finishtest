package pack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestNGForMailBoxMessages {
	public static WebDriver driver;
	final static int TIME_FOR_IMPLICITLY_WAIT = 10;
	final static int TIME_FOR_EXPLICITLY_WAIT = 20;
	public static MailBoxWorkWithMessages mailBoxMessagesPage;
	public static MailBoxLoginInBoxPage mailBoxPage;
	private WebDriver webDriver;

	@BeforeMethod
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(TIME_FOR_IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get("http://mail.ru");
		mailBoxMessagesPage = new MailBoxWorkWithMessages(driver);
		mailBoxPage = new MailBoxLoginInBoxPage(driver);
	}

	@Test(priority = 1)
	public void testForAddToSpamAllMessages() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		makeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		mailBoxMessagesPage.addAllMessagesInSpam();
		assertTrue(mailBoxMessagesPage.checkMessagesInSpam());
		//makeScreenshot();

	}

	@Test(priority = 2)
	public void testForRemoveFromSpamAllMessages() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		makeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		mailBoxMessagesPage.removeAllMessagesFromSpam();
		assertTrue(mailBoxMessagesPage.checkMessagesRemovedFromSpam());

	}

	@Test(priority = 3)
	public void testForAddToFlag() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		makeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		mailBoxMessagesPage.addFlagToMessages();
		int expectedCountOfFlaggedMessages = 4;
		assertEquals(expectedCountOfFlaggedMessages, mailBoxMessagesPage.checkBoxes.size());

	}

	@Test(priority = 4)
	public void testForRemoveFromFlag() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		makeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		assertTrue(mailBoxMessagesPage.removeFromFlag());
	}

	@Test(priority = 5)
	public void testForAddToTrashMessages() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		makeScreenshot();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		assertTrue(mailBoxMessagesPage.addAllMessagesInTrash());
	}
	@Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot()
    {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
	

	@After
	public void afterTest() {
		driver.close();
	}
}
