package tr.com.hurriyet.opensourcesdk.extraparams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOZMOS on 12/22/2016.
 */
public class FilterParamsBase {
    private static final String FILTER_PARAM_HEADER = "$filter=";
    private final List<FilterEnumBase> filterEnumsList = new ArrayList<>();

    protected void addFilterParam(FilterEnumBase filterEnumBase, FilterOperation filterOperation, String filterString) {
        filterEnumBase.set(filterOperation, filterString);
        filterEnumsList.add(filterEnumBase);
    }

    public String getFilterParamsAsString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (filterEnumsList.size() > 0) {
            stringBuilder.append(FILTER_PARAM_HEADER);
            for (int x = 0; x < filterEnumsList.size(); x++) {
                if (x == 0) {
                    stringBuilder.append(filterEnumsList.get(x).getSerializableName());
                } else {
                    stringBuilder.append(",");
                    stringBuilder.append(filterEnumsList.get(x).getSerializableName());
                }
            }
        }

        return stringBuilder.toString();
    }
}
