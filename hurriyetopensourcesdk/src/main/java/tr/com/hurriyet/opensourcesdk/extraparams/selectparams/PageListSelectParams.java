package tr.com.hurriyet.opensourcesdk.extraparams.selectparams;

import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.selectenum.PageListSelectEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class PageListSelectParams extends SelectParamsBase {

    public PageListSelectParams(PageListSelectEnum... selectParams) {
        super(selectParams);
    }
}
