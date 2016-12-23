package tr.com.hurriyet.opensourcesdk.extraparams;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public interface FilterEnumBase extends RequestEnumBase {
    void set(FilterOperation filterOperation, String filterString);
}
