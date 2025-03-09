package stepdefinitions;

import com.testAutomation.api.models.Order;
import com.testAutomation.api.questions.InventoryQuantity;
import com.testAutomation.api.questions.ResponseMatchesSchema;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.eclipse.jetty.http.HttpStatus;

import static com.testAutomation.api.utils.DataPath.PLACE_ORDER_DATA;
import static com.testAutomation.api.utils.Endpoints.STORE_ORDER;
import static com.testAutomation.api.utils.JsonReader.readJson;
import static com.testAutomation.api.utils.SchemasPath.ORDER_SCHEMA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class OrderStepDefinition {

    private int availableBefore;

    @When("the user places a new order with valid data")
    public void placeOrder() {
        availableBefore = theActorInTheSpotlight().asksFor(InventoryQuantity.current());

        Order order = readJson(PLACE_ORDER_DATA, Order.class);
        theActorInTheSpotlight().attemptsTo(
                Post.to(STORE_ORDER).with(request -> request.body(order))
        );
    }

    @Then("the order should be placed successfully")
    public void orderPlacedSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(ORDER_SCHEMA)));
        int availableAfter = theActorInTheSpotlight().asksFor(InventoryQuantity.current());
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(availableBefore).isLessThan(availableAfter)
        );
    }

    @When("the user searches for a order with id {int}")
    public void searchOrderById(int id) {
        theActorInTheSpotlight().attemptsTo(Get.resource(STORE_ORDER + id));
    }

    @Then("the order should be found successfully")
    public void orderFoundSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(ORDER_SCHEMA)));
    }

    @When("the user deletes the order with id {int}")
    public void deleteOrderById(int id) {
        theActorInTheSpotlight().attemptsTo(Delete.from(STORE_ORDER + id));
    }

    @Then("the order should be deleted successfully")
    public void orderDeletedSuccessfully() {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(HttpStatus.OK_200))
        );
    }
}