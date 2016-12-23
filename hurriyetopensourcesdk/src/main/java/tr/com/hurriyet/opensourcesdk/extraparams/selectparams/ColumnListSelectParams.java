package tr.com.hurriyet.opensourcesdk.extraparams.selectparams;

import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.selectenum.ColumnListSelectEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class ColumnListSelectParams extends SelectParamsBase {

    public ColumnListSelectParams(ColumnListSelectEnum... selectParams) {
        super(selectParams);
    }
}
