package stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.testAutomation.api.utils.SchemasPath.BASE_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class PetstoreCommonStepDefinition {
    @Given("{string} is able to use the API")
    public void setupActor(String actor) {
        theActorCalled(actor).whoCan(CallAnApi.at(BASE_URL));
    }
}