package scenarioTheaterPack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioForSearchingTheaterSiteWithMail {

	private static final String MAIN_URL = "http://mail.ru";
	public WebDriver driver;
	public MailSearchForTheaterPage searchTheater;
	final int TIME_FOR_IMPLICITLY_WAIT = 10;
	final int TIME_FOR_EXPLICITLY_WAIT = 20;

	public ScenarioForSearchingTheaterSiteWithMail() {
		driver = new ChromeDriver();
		searchTheater = new MailSearchForTheaterPage(driver);
	}

	@Given("^I am on main application page to find theater site$")
	public void loadMailSite() {
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(TIME_FOR_IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(MAIN_URL);
	}

	@When("^I fill in the search field text to find list of theater sites$")
	public void enterSearchForCinemaSiteText() {
		searchTheater.enterSearchText();
	}

	@When("^I click search button to find theater$")
	public void clickSearchButton() {
		searchTheater.clickElement();

	}

	@Ignore
	@When("^I click the first site link$")
	public void clickFirstSiteLink() {
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[@class='light-link'])[1]"))));
		searchTheater.clickLinkForCinema();

	}

	@Then("^I see the first theater site in the result search list$")
	public void checkCinemaIsFound() {
		assertTrue(searchTheater.elementIsDisplayed());
	}

}
