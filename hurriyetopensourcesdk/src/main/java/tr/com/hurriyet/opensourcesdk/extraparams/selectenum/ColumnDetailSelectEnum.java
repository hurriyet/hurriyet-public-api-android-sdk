package tr.com.hurriyet.opensourcesdk.extraparams.selectenum;

import tr.com.hurriyet.opensourcesdk.extraparams.RequestEnumBase;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum ColumnDetailSelectEnum implements RequestEnumBase {
    Id,
    ContentType,
    CreatedDate,
    Description,
    Files,
    Path,
    Title,
    Url,
    Text,
    FullName,;

    @Override
    public String getSerializableName() {
        return this.toString();
    }
}
