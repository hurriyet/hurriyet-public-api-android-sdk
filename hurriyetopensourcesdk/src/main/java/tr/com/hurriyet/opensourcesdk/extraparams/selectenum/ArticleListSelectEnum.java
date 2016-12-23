package tr.com.hurriyet.opensourcesdk.extraparams.selectenum;

import tr.com.hurriyet.opensourcesdk.extraparams.RequestEnumBase;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum ArticleListSelectEnum implements RequestEnumBase {
    Id,
    ContentType,
    CreatedDate,
    Description,
    Files,
    ModifiedDate,
    Path,
    Title,
    Url,
    RelatedNews,
    Tags,
    Text,
    Writers,;

    @Override
    public String getSerializableName() {
        return this.toString();
    }
}
