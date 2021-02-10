package seleniumautomation.com.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue={"seleniumautomation.com.stepDefinitions"},tags = "@Test", features = "src/test/resources", plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber.json" })
public class RunCucumberTests {
}

