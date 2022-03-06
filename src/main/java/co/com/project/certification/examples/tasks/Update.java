package co.com.project.certification.examples.tasks;

import co.com.project.certification.examples.models.Example;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.project.certification.examples.utils.EndPoints.PATH;

public class Update implements Task {

    private String parameter;
    private List<Example> data;

    public Update(String parameter, List<Example> data) {
        this.parameter = parameter;
        this.data = data;
    }

    public static Update to(String parameter, List<Example> data) {
        return Tasks.instrumented(Update.class, parameter, data);
    }

    public Map<String, Object> request() {
        Map<String, Object> request = new HashMap<>();
        Map<String, Object> user = new HashMap<>();
        user.put("user", data);
        request.put("data", user);
        return request;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH).with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .header("???", parameter)
                        .body(request())
                )
        );
    }
}
