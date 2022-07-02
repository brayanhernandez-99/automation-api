package in.reqres.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Response implements Question {

    public static Response response() {
        return new Response();
    }

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Response.class);
    }
}
