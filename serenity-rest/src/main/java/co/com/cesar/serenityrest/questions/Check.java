package co.com.cesar.serenityrest.questions;

import co.com.cesar.serenityrest.models.UsersResponse;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Check implements Question<UsersResponse> {


    @Override
    public UsersResponse answeredBy(Actor actor) {
       UsersResponse usersResponse = SerenityRest.lastResponse()
               .getBody()
               .as(UsersResponse.class);
        System.out.println(usersResponse);
        return SerenityRest.lastResponse().getBody().as(UsersResponse.class);
    }

    public static Check theUsersResponse(){
        return new Check();
    }
}
