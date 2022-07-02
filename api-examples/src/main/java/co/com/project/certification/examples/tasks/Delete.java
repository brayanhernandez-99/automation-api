package co.com.project.certification.examples.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.project.certification.examples.utils.EndPoints.PATH;

public class Delete implements Task {

    private String delete;

    public Delete(String delete) {
        this.delete = delete;
    }

    public static Delete to(String delete) {
        return Tasks.instrumented(Delete.class, delete);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.rest.interactions.Delete.from(PATH).with(requestSpecification -> requestSpecification
                        .header("???", delete)
                )
        );
    }
}
