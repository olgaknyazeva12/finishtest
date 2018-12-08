package patternpack;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AppTest {
	public static WebDriver driver;

	public static FactoryAnswer answer;
	private static final int LINK_PRESENSE_TIMEOUT = 10;
	private final static String LINK = "https://mail.ru/";

	@Before
	public void beforeClass() {
		driver = Singleton.getInstance();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(LINK_PRESENSE_TIMEOUT, TimeUnit.SECONDS);
		driver.get(LINK);
		answer = new FactoryAnswer(driver);
	}

	@Test
	public void answerIsShown() {

		Assert.assertTrue(answer.factoryAnswerAll());

	}

	@After
	public void after() {
		driver.close();
	}

}
