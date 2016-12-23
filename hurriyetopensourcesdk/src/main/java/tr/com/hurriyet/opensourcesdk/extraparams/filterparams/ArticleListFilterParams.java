package tr.com.hurriyet.opensourcesdk.extraparams.filterparams;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterOperation;
import tr.com.hurriyet.opensourcesdk.extraparams.FilterParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.filterenums.ArticleListFilterEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class ArticleListFilterParams extends FilterParamsBase {

    public void addFilterParam(ArticleListFilterEnum path, FilterOperation filterOperation, String filterString) {
        super.addFilterParam(path, filterOperation, filterString);
    }
}
