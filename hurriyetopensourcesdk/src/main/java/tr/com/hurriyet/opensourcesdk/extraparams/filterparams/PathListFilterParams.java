package tr.com.hurriyet.opensourcesdk.extraparams.filterparams;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterOperation;
import tr.com.hurriyet.opensourcesdk.extraparams.FilterParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.filterenums.PathListFilterEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class PathListFilterParams extends FilterParamsBase {

    public void addFilterParam(PathListFilterEnum path, FilterOperation filterOperation, String filterString) {
        super.addFilterParam(path, filterOperation, filterString);
    }
}