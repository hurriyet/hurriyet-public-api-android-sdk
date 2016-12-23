package tr.com.hurriyet.opensourcesdk.extraparams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class SelectParamsBase {
    private static final String SELECT_PARAM_HEADER = "$select=";
    private final List<RequestEnumBase> selectEnumsList;

    private SelectParamsBase() {
        selectEnumsList = new ArrayList<>();
    }

    public SelectParamsBase(RequestEnumBase... selectEnums) {
        selectEnumsList = new ArrayList<>();
        if (selectEnums != null && selectEnums.length > 0) {
            for (RequestEnumBase selectEnum : selectEnums) {
                if (selectEnum != null) {
                    selectEnumsList.add(selectEnum);
                }
            }
        }
    }

    public String getSelectParamsAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (selectEnumsList != null && selectEnumsList.size() > 0) {
            stringBuilder.append(SELECT_PARAM_HEADER);
            for (int x = 0; x < selectEnumsList.size(); x++) {
                if (x == 0) {
                    stringBuilder.append(selectEnumsList.get(x).getSerializableName());
                } else {
                    stringBuilder.append(",");
                    stringBuilder.append(selectEnumsList.get(x).getSerializableName());
                }
            }
        }

        return stringBuilder.toString();
    }
}