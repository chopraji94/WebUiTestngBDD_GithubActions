package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features", glue = {"StepDefinitions","Hooks"})
public class TestRuner extends AbstractTestNGCucumberTests {

}