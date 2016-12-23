package tr.com.hurriyet.opensourcesdk.extraparams.selectenum;

import tr.com.hurriyet.opensourcesdk.extraparams.RequestEnumBase;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum PageDetailSelectEnum implements RequestEnumBase {
    Id,
    CreatedDate,
    Title,
    Url,
    PageNews,;

    @Override
    public String getSerializableName() {
        return this.toString();
    }
}
