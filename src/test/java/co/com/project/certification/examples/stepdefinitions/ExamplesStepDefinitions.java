package co.com.project.certification.examples.stepdefinitions;

import co.com.project.certification.examples.exceptions.NotMatchException;
import co.com.project.certification.examples.models.Example;
import co.com.project.certification.examples.questions.Response;
import co.com.project.certification.examples.questions.StatusCode;
import co.com.project.certification.examples.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

import static co.com.project.certification.examples.utils.EndPoints.BASE_URL;
import static net.serenitybdd.rest.RestDefaults.useRelaxedHTTPSValidation;

public class ExamplesStepDefinitions {

    @Before
    public void start() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        OnStage.theActorCalled("User");
        useRelaxedHTTPSValidation();
    }

    @When("^the user to create with some parameter (.*) and the data$")
    public void theUserToCreateWithSomeParameterAndTheData(String parameter, List<Example> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Create.to(parameter, data));
    }

    @When("^the user to update with some parameter (.*) and the data$")
    public void theUserToUpdateWithSomeParameterAndTheData(String parameter, List<Example> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Update.to(parameter, data));
    }

    @When("^the user to find with the data$")
    public void theUserToFindWithTheData(List<Example> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Find.to(data));
    }

    @When("^the user to delete the user (.*)")
    public void theUserToDeleteTheUser(String delete) {
        OnStage.theActorInTheSpotlight().attemptsTo(Delete.to(delete));
    }

    @When("^The user tests the scenario outline with the data$")
    public void theUserTestsTheScenarioOutlineWithTheData(List<Example> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(Outline.to(data));
    }

    @Then("^should see status code (.*)$")
    public void shouldSeeStatusCode(int statusCode) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(StatusCode.statusCode(), Matchers.equalTo(statusCode)).orComplainWith(NotMatchException.class, "Status code does not match")
        );
    }

    @And("^should see a response (.*)$")
    public void ShouldSeeAResponse(String response) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(Response.response(), Matchers.equalTo(response)).orComplainWith(NotMatchException.class, "Response Api does not match")
        );
    }
}