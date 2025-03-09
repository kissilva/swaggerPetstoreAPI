package stepdefinitions;

import com.testAutomation.api.models.User;
import com.testAutomation.api.questions.ResponseMatchesSchema;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.eclipse.jetty.http.HttpStatus;

import static com.testAutomation.api.utils.DataPath.CREATE_USER_DATA;
import static com.testAutomation.api.utils.DataPath.LOGIN_USER_DATA;
import static com.testAutomation.api.utils.Endpoints.USER;
import static com.testAutomation.api.utils.Endpoints.USER_LOGIN;
import static com.testAutomation.api.utils.JsonReader.readJson;
import static com.testAutomation.api.utils.SchemasPath.USER_SCHEMA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UserStepDefinition {

    @When("the user searches for a user with username {string}")
    public void searchUser(String username) {
        theActorInTheSpotlight().attemptsTo(
                Get.resource(USER + username)
        );
    }

    @Then("the user should be found successfully")
    public void theUserShouldBeFoundSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(USER_SCHEMA)));
    }

    @Then("the user search should fail")
    public void theUserSearchShouldFail() {
        theActorInTheSpotlight().should(
                seeThatResponse(validatableResponse ->
                        validatableResponse.statusCode(HttpStatus.NOT_FOUND_404)
                )
        );
    }

    @When("the logged user creates a new user with valid data")
    public void createUser() {
        User user = readJson(CREATE_USER_DATA, User.class);
        theActorInTheSpotlight().attemptsTo(
                Post.to(USER)
                        .with(request -> request.body(user))
        );
    }

    @Then("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(USER_SCHEMA)));

    }

    @When("the user log in with valid credentials")
    public void loginUser() {
        User user = readJson(LOGIN_USER_DATA, User.class);
        theActorInTheSpotlight().attemptsTo(
                Get.resource(USER_LOGIN)
                        .with(request -> request
                                .queryParam("username", user.getUsername())
                                .queryParam("password", user.getPassword()))
        );
    }

    @Then("he should be logged in successfully")
    public void heShouldBeLoggedInSuccessfully() {
        theActorInTheSpotlight().should(
                seeThatResponse(validatableResponse ->
                        validatableResponse.statusCode(HttpStatus.OK_200)
                )
        );
    }
}