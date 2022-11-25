package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/java/appfeatures/web"},
        glue= {"stepdefs", "hooks"},
        plugin = {"pretty", "html:target/HtmlReports"}
)
public class AppRunner {
}
