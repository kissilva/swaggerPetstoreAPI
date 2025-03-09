package com.testAutomation.api.utils;

import static com.testAutomation.api.utils.TestEnvironments.getProperty;

public class SchemasPath {
    public static final String BASE_URL = getProperty("restapi.baseurl");
    public static final String PET_SCHEMA = getProperty("schemas.petResponse");
    public static final String USER_SCHEMA = getProperty("schemas.userResponse");
    public static final String ORDER_SCHEMA = getProperty("schemas.orderResponse");
}
