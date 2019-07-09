package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,
        features = "src/test/java/features/",
        glue = "stepDefinitions",
        tags = "@careers")

public class TestRunner {
}
