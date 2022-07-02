package in.reqres.stepdefinitions;

import in.reqres.exceptions.NotMatchException;
import in.reqres.questions.ValidateUser;
import in.reqres.tasks.GetMethod;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static net.serenitybdd.rest.RestDefaults.useRelaxedHTTPSValidation;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;
import static in.reqres.utils.Constants.*;

public class StepDefinitions {


    @Before
    public void start() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(ENDPOINT)));
        OnStage.theActorCalled("User");
        useRelaxedHTTPSValidation();
    }

    @When("users are consulted")
    public void usersAreConsulted() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetMethod.to(USERS));
    }

    @Then("should see the data correctly")
    public void shouldSeeTheDataCorrectly() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateUser.validate()));
    }

}
