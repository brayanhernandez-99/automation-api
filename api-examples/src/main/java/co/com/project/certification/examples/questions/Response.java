package co.com.project.certification.examples.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Response implements Question {

    public static Response response() {
        return new Response();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return "response " + SerenityRest.lastResponse().jsonPath().getString("response.details");
    }
}