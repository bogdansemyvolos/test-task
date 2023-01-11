package utils;

import static java.util.Objects.isNull;

public class EnvProperties {

    private static final String PROPERTIES_FILE_NAME = "env.properties";
    private static final String BASE_URL = "baseURL";
    private static final String LOG_REQUEST = "logRequest";
    private static final String LOG_RESPONSE = "logResponse";
    private static final String ACCESS_KEY = "accessKey";

    public static String baseURL() {
        String systemProperty = System.getProperty(BASE_URL);
        return !isNull(systemProperty) ? systemProperty : PropertiesReader.getProperty(PROPERTIES_FILE_NAME, BASE_URL);
    }

    public static String logRequest() {
        String systemProperty = System.getProperty(LOG_REQUEST);
        return !isNull(systemProperty) ? systemProperty : PropertiesReader.getProperty(PROPERTIES_FILE_NAME, LOG_REQUEST);
    }

    public static String logResponse() {
        String systemProperty = System.getProperty(LOG_RESPONSE);
        return !isNull(systemProperty) ? systemProperty : PropertiesReader.getProperty(PROPERTIES_FILE_NAME, LOG_RESPONSE);
    }

    public static String accessKey() {
        String systemProperty = System.getProperty(ACCESS_KEY);
        return !isNull(systemProperty) ? systemProperty : PropertiesReader.getProperty(PROPERTIES_FILE_NAME, ACCESS_KEY);
    }
}
