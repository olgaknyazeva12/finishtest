package parserpack;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.SAXException;

public class parserSearchTests {
	public static WebDriver driver;
	public static AnimalSearchPage animal;
	final static int TIME_FOR_IMPLICITLY_WAIT = 10;
	final static int TIME_FOR_EXPLICITLY_WAIT = 20;

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(TIME_FOR_IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get("http://mail.ru");
		animal = new AnimalSearchPage(driver);

	}

	@Test
	public void searchForAnimalPicture()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		animal.clickPictureSearch();
		animal.enterPictureNameSax();
		animal.clickFindButton();
		assertTrue(animal.firstSearchPictureIsDisplayed());
	}

	@Test
	public void searchForAnimalVideo()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		animal.clickVideoSearch();
		animal.enterVideoNameStax();
		animal.clickFindButton();
		assertTrue(animal.firstSearchVideoIsDisplayed());
	}

	@Test
	public void searchForAnimalApp()
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		animal.clickAppSearch();
		animal.enterAppNameDom();
		animal.clickFindButton();
		assertTrue(animal.firstSearchAppIsDisplayed());
	}

	@After
	public void after() {

		driver.close();
	}

}
