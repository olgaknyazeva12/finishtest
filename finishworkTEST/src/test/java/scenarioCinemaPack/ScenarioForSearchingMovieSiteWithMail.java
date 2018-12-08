package scenarioCinemaPack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioForSearchingMovieSiteWithMail {

	private static final String MAIN_URL = "http://mail.ru";
	public WebDriver driver;
	public MailSearchForCinemaPage searchCinema;
	final int TIME_FOR_IMPLICITLY_WAIT = 10;
	final int TIME_FOR_EXPLICITLY_WAIT = 20;
	private static final Logger log = Logger.getLogger(MailSearchForCinemaPage.class);
	
	public ScenarioForSearchingMovieSiteWithMail() {
		driver = new ChromeDriver();
		searchCinema = new MailSearchForCinemaPage(driver);
	}

	@Given("^I am on main application page$")
	public void loadMailSite() {
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(TIME_FOR_IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(MAIN_URL);
		log.info("The mail.ru is launched successfully!");
	}

	@When("^I fill in the search field text to find list of movie sites$")
	public void enterSearchForCinemaSiteText() {
		searchCinema.enterSearchText();
		log.info("The enterSearchForCinemaSiteText method is run successfully!");
	}

	@When("^I click search button$")
	public void clickSearchButton() {
		searchCinema.clickElement();
		log.info("The clickSearchButton method is run successfully!");
	}

	@Ignore
	@When("^I click the first site link$")
	public void clickFirstSiteLink() {
		WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_EXPLICITLY_WAIT);
		wait.until(ExpectedConditions
				.not(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[@class='light-link'])[1]"))));
		searchCinema.clickLinkForCinema();

	}

	@Then("^I see the first site in the result search list$")
	public void checkCinemaIsFound() {
		assertTrue(searchCinema.elementIsDisplayed());
		log.info("The checkCinemaIsFound method is run successfully and assert is completed!");
	}

}
