package com.testAutomation.api.utils;

import static com.testAutomation.api.utils.TestEnvironments.getProperty;

public class DataPath {
    public static final String CREATE_PET_DATA = getProperty("data.createPet");
    public static final String UPDATE_PET_DATA = getProperty("data.updatePet");
    public static final String PLACE_ORDER_DATA = getProperty("data.placeOrder");
    public static final String CREATE_USER_DATA = getProperty("data.createUser");
    public static final String LOGIN_USER_DATA = getProperty("data.createUser");
}
