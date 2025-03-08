package com.testAutomation.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.Get;
import io.restassured.response.Response;
import java.util.Map;

import static com.testAutomation.api.utils.TestEnvironments.STORE_INVENTORY;

public class InventoryQuantity implements Question<Integer> {

    public static Question<Integer> current() {
        return new InventoryQuantity();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        actor.attemptsTo(Get.resource(STORE_INVENTORY));
        Response response = SerenityRest.lastResponse();
        Map<String, Integer> inventory = response.jsonPath().getMap("$");
        return inventory.getOrDefault("approved", 0);

    }

}