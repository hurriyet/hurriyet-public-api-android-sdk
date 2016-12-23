package tr.com.hurriyet.opensourcesdk.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import tr.com.hurriyet.opensourcesdk.exceptions.UninitializedSdkException;

/**
 * Created by austa on 15/12/2016.
 */

public final class HVolleyHelper {
    protected static HashMap<String, String> getDefaultHeaders() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/json");
        try {
            headers.put("apikey", RequestGenerator.get().getApiKey());
        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
        return headers;
    }
}
