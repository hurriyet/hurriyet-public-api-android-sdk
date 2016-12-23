package tr.com.hurriyet.opensourcesdk.services;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by austa on 20/12/16.
 */
public class HGsonParser<T> implements HParser<T> {

    /**
     * Type of Generic.
     */
    private final Class<T> mTypeOfT;

    /**
     * GSON parser
     */
    private final Gson mGson;

    public HGsonParser(Class<T> pMTypeOfT, Gson pMGson) {
        super();
        mTypeOfT = pMTypeOfT;
        mGson = pMGson;
    }

    @Override
    public Response<T> parse(NetworkResponse response) {
        String jsonString = "";
        try {
            jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }

        try {
            return Response.success(mGson.fromJson(jsonString, mTypeOfT), HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }
}
