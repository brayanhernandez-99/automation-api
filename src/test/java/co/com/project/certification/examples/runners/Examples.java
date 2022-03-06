package co.com.project.certification.examples.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/examples.feature",
        glue = "co.com.project.certification.examples.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Examples {
}
