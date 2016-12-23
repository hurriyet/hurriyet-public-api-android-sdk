package tr.com.hurriyet.opensourcesdk.extraparams.selectparams;

import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.selectenum.ColumnDetailSelectEnum;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class ColumnDetailSelectParams extends SelectParamsBase {

    public ColumnDetailSelectParams(ColumnDetailSelectEnum... selectParams) {
        super(selectParams);
    }
}
