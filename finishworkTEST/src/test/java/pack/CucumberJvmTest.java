package pack;

import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/"},tags = {})
public class CucumberJvmTest extends AbstractTestNGCucumberTests {

}
