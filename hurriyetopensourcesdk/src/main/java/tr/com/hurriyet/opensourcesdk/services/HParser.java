
package tr.com.hurriyet.opensourcesdk.services;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;

/**
 * Created by austa on 18/12/2016.
 */

public interface HParser<T> {
    public Response<T> parse(final NetworkResponse response);
}
