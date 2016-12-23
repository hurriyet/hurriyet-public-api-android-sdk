package tr.com.hurriyet.opensourcesdk.extraparams.selectenum;

import tr.com.hurriyet.opensourcesdk.extraparams.RequestEnumBase;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum PageListSelectEnum implements RequestEnumBase {
    Id,
    CreatedDate,
    Title,
    Url,;

    @Override
    public String getSerializableName() {
        return this.toString();
    }
}
