package in.reqres.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetMethod implements Task {

    private String path;

    public GetMethod(String path) {
        this.path = path;
    }

    public static GetMethod to(String path) {
        return Instrumented.instanceOf(GetMethod.class).withProperties(path);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path));
    }
}
