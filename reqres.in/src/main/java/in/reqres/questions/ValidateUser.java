package in.reqres.questions;

import in.reqres.exceptions.NotMatchException;
import in.reqres.models.Response;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class ValidateUser implements Question {

    public static ValidateUser validate() {
        return Instrumented.instanceOf(ValidateUser.class).withProperties();
    }

    @Override
    public Object answeredBy(Actor actor) {
        Response response = new Response();
        actor.should(
                seeThat("status code", StatusCode.is(), Matchers.equalTo(200)).orComplainWith(NotMatchException.class, "Status code does not match"),
                seeThat("page", ACTOR -> response.getPage(), Matchers.equalTo(1)).orComplainWith(NotMatchException.class, "Total registers not match")),
                seeThat("per_page", ACTOR -> response.getPer_page(), Matchers.equalTo(12)).orComplainWith(NotMatchException.class, "Total registers not match")),
                seeThat("total", ACTOR -> response.getTotal(), Matchers.equalTo(12)).orComplainWith(NotMatchException.class, "Total registers not match")),
                seeThat("total_pages", ACTOR -> response.getTotal_pages(), Matchers.equalTo(12)).orComplainWith(NotMatchException.class, "Total registers not match")),

                seeThat("total registers", ACTOR -> usersResponse.getTotal(), Matchers.equalTo(12)).orComplainWith(NotMatchException.class, "Total registers not match")),
                seeThat("support URL", ACTOR -> usersResponse.getSupport().getUrl(), containsString("reqres.in")),
                seeThat("first name", ACTOR -> usersResponse.getData().get(3).getFirst_name(), equalTo("Byron")),
                seeThat("total per pag", ACTOR -> usersResponse.getPer_page(), equalTo(usersResponse.getData().size())),
                seeThatResponse("All users on page 2 should be returned", response -> response.body("data.first_name", hasItems("Tobias", "Lindsay", "Rachel"))),
                seeThatResponse("status code", response -> response.statusCode(200)))
        );


        return SerenityRest.lastResponse().getBody().as(Response.class);
    }
}
