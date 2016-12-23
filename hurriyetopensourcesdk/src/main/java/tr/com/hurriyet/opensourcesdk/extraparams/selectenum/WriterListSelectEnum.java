package tr.com.hurriyet.opensourcesdk.extraparams.selectenum;

import tr.com.hurriyet.opensourcesdk.extraparams.RequestEnumBase;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum WriterListSelectEnum implements RequestEnumBase {
    Id,
    ContentType,
    CreatedDate,
    Files,
    Path,
    Url,
    Fullname,;

    @Override
    public String getSerializableName() {
        return this.toString();
    }
}
