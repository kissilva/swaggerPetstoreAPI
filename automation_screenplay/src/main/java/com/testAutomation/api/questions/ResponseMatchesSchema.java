package com.testAutomation.api.questions;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;

import static com.testAutomation.api.utils.TestEnvironments.*;

public class ResponseMatchesSchema implements Question<Boolean> {

    private final String schemaPath;

    public ResponseMatchesSchema(String schemaPath) {
        this.schemaPath = schemaPath;
    }

    public static ResponseMatchesSchema forSchema(String schemaPath) {
        return new ResponseMatchesSchema(schemaPath);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LastResponse.received().answeredBy(actor)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath))
                .extract()
                .response()
                .getStatusCode() == HttpStatus.SC_OK;
    }
}