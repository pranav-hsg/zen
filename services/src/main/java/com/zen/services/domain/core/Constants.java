package com.zen.services.domain.core;


import java.math.BigDecimal;

/**
 * Application constants.
 */
public final class Constants {
    public static final BigDecimal GST = new BigDecimal("18");
    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymousUser";
    public static final String DEFAULT_LANGUAGE = "en";

    private Constants() {
    }
}
