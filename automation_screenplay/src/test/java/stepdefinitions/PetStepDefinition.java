package stepdefinitions;

import com.testAutomation.api.models.Pet;
import com.testAutomation.api.questions.ResponseMatchesSchema;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.eclipse.jetty.http.HttpStatus;

import static com.testAutomation.api.utils.DataPath.CREATE_PET_DATA;
import static com.testAutomation.api.utils.DataPath.UPDATE_PET_DATA;
import static com.testAutomation.api.utils.Endpoints.PET;
import static com.testAutomation.api.utils.JsonReader.readJson;
import static com.testAutomation.api.utils.SchemasPath.PET_SCHEMA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PetStepDefinition {

    @When("the user searches for a pet with id {int}")
    public void searchPetById(int id) {
        theActorInTheSpotlight().attemptsTo(Get.resource(PET + id));
    }

    @Then("the pet should be found successfully")
    public void petFoundSuccessfully() {

        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(PET_SCHEMA)));
    }

    @Then("the pet search should fail")
    public void petNotFound() {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(HttpStatus.NOT_FOUND_404))
        );
    }

    @When("the user updates an existing pet")
    public void updatePet() {
        Pet pet = readJson(UPDATE_PET_DATA, Pet.class);
        theActorInTheSpotlight().attemptsTo(
                Put.to(PET).with(request -> request.body(pet))
        );
    }

    @Then("the pet should be updated successfully")
    public void petUpdatedSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(PET_SCHEMA)));
    }

    @When("the user creates a new pet with valid data")
    public void createPet() {
        Pet pet = readJson(CREATE_PET_DATA, Pet.class);
        theActorInTheSpotlight().attemptsTo(
                Post.to(PET).with(request -> request.body(pet))
        );
    }

    @Then("the pet should be created successfully")
    public void petCreatedSuccessfully() {
        theActorInTheSpotlight().should(seeThat(ResponseMatchesSchema.forSchema(PET_SCHEMA)));
    }

    @When("the user deletes the pet with id {int}")
    public void deletePetById(int id) {
        theActorInTheSpotlight().attemptsTo(Delete.from(PET + id));
    }

    @Then("the pet should be deleted successfully")
    public void petDeletedSuccessfully() {
        theActorInTheSpotlight().should(
                seeThatResponse(response -> response.statusCode(HttpStatus.OK_200))
        );
    }
}