package tr.com.hurriyet.opensourcesdk.services;

/**
 * Constants
 *
 * @author austa
 */

public class BuildConstants {
    public static final String DEFAULT_TEXT_ENCODING = "utf-8";
    public static final int SERVICE_TIMEOUT_DURATION = 60000;
    public static final String BODY_CONTENT_TYPE = "application/json";
    public static final String SERVICE_URL_PROD = "api.hurriyet.com.tr";

    public static String getServiceUrl() {
        return SERVICE_URL_PROD;
    }

}