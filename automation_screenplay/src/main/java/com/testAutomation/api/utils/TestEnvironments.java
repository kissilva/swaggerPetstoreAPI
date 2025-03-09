package com.testAutomation.api.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.configuration.SystemPropertiesConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import java.util.Optional;

public class TestEnvironments {

    private static final SystemPropertiesConfiguration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();

    private TestEnvironments() {
    }

    public static String getProperty(String nameProperty) {
        return Optional.ofNullable(
                        EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(nameProperty))
                .orElseThrow(() -> new IllegalArgumentException("Property not found: " + nameProperty));
    }
}