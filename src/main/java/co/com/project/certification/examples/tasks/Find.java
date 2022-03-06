package co.com.project.certification.examples.tasks;

import co.com.project.certification.examples.models.Example;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static co.com.project.certification.examples.utils.EndPoints.PATH;

public class Find implements Task {
    private List<Example> data;

    public Find(List<Example> data) {
        this.data = data;
    }

    public static Find to(List<Example> data) {
        return Tasks.instrumented(Find.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH).with( requestSpecification -> requestSpecification
                        .params("name", data.get(0).getName())
                        .params("last_name", data.get(0).getLast_name())
                        .params("phone", data.get(0).getPhone())
                )

        );
    }
}
