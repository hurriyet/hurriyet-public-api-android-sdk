package tr.com.hurriyet.opensourcesdk.extraparams.selectparams;

import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.selectenum.ArticleListSelectEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class ArticleListSelectParams extends SelectParamsBase {

    public ArticleListSelectParams(ArticleListSelectEnum... selectParams) {
        super(selectParams);
    }
}
