package tr.com.hurriyet.opensourcesdk.extraparams.filterenums;

import android.text.TextUtils;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterEnumBase;
import tr.com.hurriyet.opensourcesdk.extraparams.FilterOperation;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public enum PhotoGalleryListFilterEnum implements FilterEnumBase {
    Id,
    ModifiedDate,
    Path,;

    protected FilterOperation filterOperation;
    protected String filterString;

    @Override
    public void set(FilterOperation filterOperation, String filterString) {
        this.filterOperation = filterOperation;
        this.filterString = filterString;
    }

    @Override
    public String getSerializableName() {
        if (filterOperation != null && !TextUtils.isEmpty(filterString)) {
            return this.toString() + " " + filterOperation + " " + "'" + filterString + "'";
        }
        return "";
    }
}
