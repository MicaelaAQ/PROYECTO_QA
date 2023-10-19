package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"stepdefinitions"},
        features = "src/test/resources/features/aventaja.feature",
        snippets = SnippetType.CAMELCASE)
public class AventajaRunner {


}
