package tr.com.hurriyet.opensourcesdk.services;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Primitives;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import tr.com.hurriyet.opensourcesdk.exceptions.UninitializedSdkException;
import tr.com.hurriyet.opensourcesdk.model.ErrorModel;

/**
 * Created by austa on 15/12/2016.
 * Volley request parsing JSON object and JSON array to strings using the gson
 * deserializer supports GZIP
 */
public class GsonRequest<T> extends Request<T> {

    /**
     * Type of Generic.
     */
    private final Class<T> mTypeOfT;

    /**
     * GSON parser
     */
    private final Gson mGson;

    /**
     * Request headers
     */
    private Map<String, String> mHeaders = new HashMap<String, String>();

    /**
     * Request body
     */
    private String mRequestBody;
    private Object mBody;

    /**
     * Method
     */
    private ServiceMethod mMethod;

    /**
     * Error model
     */
    private ErrorModel errorModel;

    /**
     * Create a new GSON JSON-parser request with a custom gson instance (useful
     * for specifying custom date formats, etc.)
     *
     * @param method  Request url.
     * @param body    Request body.
     * @param typeOfT Type of generic.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public GsonRequest(final ServiceMethod method, final Object body, final Class<T> typeOfT)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        super(method.getMethodType(), method.constructUrl(), null);

        GsonBuilder gsonBuilder = new GsonBuilder();
        this.mGson = gsonBuilder.create();
        this.mMethod = method;
        this.mBody = body;
        this.mHeaders = HVolleyHelper.getDefaultHeaders();
        this.mRequestBody = body == null ? null : mGson.toJson(body);
        this.errorModel = new ErrorModel();
        this.mTypeOfT = typeOfT;
    }


    @Override
    protected Response<T> parseNetworkResponse(final NetworkResponse response) {
        HGsonParser<T> parser = new HGsonParser<T>(mTypeOfT, mGson);
        return parser.parse(response);
    }


    @Override
    protected void deliverResponse(final T response) {
        // Todo parse edilmis response buradan paslanacak bu eventbus isini halledelim
        try {
            RequestGenerator.get().getBus().post(Primitives.wrap(mTypeOfT).cast(response));
        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deliverError(VolleyError error) {
        Log.wtf("Exception? ", error);
        // Todo Error buradan paslanacak bu eventbus isini halledelim
        try {
            RequestGenerator.get().getBus().post(errorModel);
        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return mHeaders != null ? mHeaders : super.getHeaders();
    }

    @Override
    public String getBodyContentType() {
        return BuildConstants.BODY_CONTENT_TYPE;
    }

    public byte[] getBody() throws AuthFailureError {
        try {
            return mRequestBody == null ? null : mRequestBody.getBytes(BuildConstants.DEFAULT_TEXT_ENCODING);
        } catch (UnsupportedEncodingException uee) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody,
                    BuildConstants.DEFAULT_TEXT_ENCODING);
            return null;
        }
    }
}