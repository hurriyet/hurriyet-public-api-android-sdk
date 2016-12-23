package tr.com.hurriyet.opensourcesdk.extraparams.filterparams;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterOperation;
import tr.com.hurriyet.opensourcesdk.extraparams.FilterParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.filterenums.WriterListFilterEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class WriterListFilterParams extends FilterParamsBase {

    public void addFilterParam(WriterListFilterEnum path, FilterOperation filterOperation, String filterString) {
        super.addFilterParam(path, filterOperation, filterString);
    }
}
