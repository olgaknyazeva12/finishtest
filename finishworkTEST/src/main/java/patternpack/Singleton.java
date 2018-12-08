package patternpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
	private static WebDriver driver;

	public static WebDriver getInstance() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
}
