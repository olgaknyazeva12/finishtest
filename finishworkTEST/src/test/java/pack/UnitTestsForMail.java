package pack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pack.Mail;
import pack.MailBoxLoginInBoxPage;

public class UnitTestsForMail {
	public static WebDriver driver;
	public static WebDriver driver1;
	public static MailBoxLoginInBoxPage mailBoxPage;
	public static Mail mail;

	final static int TIME_FOR_IMPLICITLY_WAIT = 10;
	final static int TIME_FOR_EXPLICITLY_WAIT = 20;

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(TIME_FOR_IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get("http://mail.ru");
		mailBoxPage = new MailBoxLoginInBoxPage(driver);

	}

	@Test
	public void testForLogin() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		assertTrue(mailBoxPage.logoutIsDisplayed());

	}

	@Test
	public void testForLogout() {
		mailBoxPage.enterLoginAndPass();
		mailBoxPage.clickEnterButton();
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_logoutLink']"))));
		mailBoxPage.clickLogoutButton();
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='PH_authLink']"))));
		assertTrue(mailBoxPage.loginIsDisplayed());
	}

	@Test
	public void testForCheckingFindButtonText() {
		WebElement element = driver.findElement(By.xpath("//input[@id='search:submit']"));
		assertTrue(element.isDisplayed());
	}

	@After
	public void after() {

		driver.close();
	}

}
