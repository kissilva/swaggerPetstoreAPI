package com.testAutomation.api.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.configuration.SystemPropertiesConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.Optional;

public class TestEnvironments {

    private static final SystemPropertiesConfiguration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();

    public static final String PET = "/pet/";
    public static final String USER = "/user/";
    public static final String STORE = "/store/";
    public static final String STORE_INVENTORY = STORE + "inventory/";
    public static final String STORE_ORDER = STORE + "order/";
    public static final String USER_LOGIN = USER + "login/";
    public static final String BASE_URL = getProperty("restapi.baseurl");
    public static final String PET_SCHEMA = getProperty("schemas.petResponse");
    public static final String USER_SCHEMA = getProperty("schemas.userResponse");
    public static final String ORDER_SCHEMA = getProperty("schemas.orderResponse");
    public static final String CREATE_PET_DATA = getProperty("data.createPet");
    public static final String UPDATE_PET_DATA = getProperty("data.updatePet");
    public static final String PLACE_ORDER_DATA = getProperty("data.placeOrder");
    public static final String CREATE_USER_DATA = getProperty("data.createUser");
    public static final String LOGIN_USER_DATA = getProperty("data.createUser");

    private TestEnvironments() {
    }

    private static String getProperty(String nameProperty) {
        return Optional.ofNullable(
                        EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(nameProperty))
                .orElseThrow(() -> new IllegalArgumentException("Property not found: " + nameProperty));
    }
}