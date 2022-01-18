package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/tests.feature",
        glue = "stepdefinitions"
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
