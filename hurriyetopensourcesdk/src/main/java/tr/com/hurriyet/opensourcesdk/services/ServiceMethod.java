package tr.com.hurriyet.opensourcesdk.services;

import android.text.TextUtils;

import com.android.volley.Request.Method;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterParamsBase;
import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;

public enum ServiceMethod {

    ARTICLE(Method.GET, false, "/v1/articles"),
    COLUMN(Method.GET, false, "/v1/columns"),
    PHOTOGALLERY(Method.GET, false, "/v1/newsphotogalleries"),
    PAGES(Method.GET, false, "/v1/pages"),
    PATH(Method.GET, false, "/v1/paths"),
    WRITER(Method.GET, false, "/v1/writers");

    private final String BASE_URL = BuildConstants.getServiceUrl();
    private int methodType;
    private boolean useSSL;
    private String httpUrl;
    private String id;
    private Integer top;
    private SelectParamsBase selectParams;
    private FilterParamsBase filterParamsBase;

    ServiceMethod(int methodType, boolean useSSL, String url) {
        this.methodType = methodType;
        this.useSSL = useSSL;
        this.httpUrl = url;
    }

    public int getMethodType() {
        return this.methodType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return httpUrl;
    }

    public String constructUrl() {
        StringBuilder construction = new StringBuilder(constructInitials());
        if (!TextUtils.isEmpty(id))
            construction.append("/" + id);
        if (urlParameters() != null)
            construction.append(urlParameters());

        return construction.toString();
    }

    private StringBuilder constructInitials() {
        StringBuilder construction = new StringBuilder();
        return construction.append("https://").append(BASE_URL).append(httpUrl);
    }


    private String urlParameters() {
        if (getTop() == null && getSelectParams() == null)
            return null;

        StringBuilder sb = new StringBuilder("?");

        if (getSelectParams() != null)
            sb.append(getSelectParams().getSelectParamsAsString());

        if (getTop() != null) {
            if (getSelectParams() != null)
                sb.append("&");

            sb.append(getTop());
        }

        if (getFilterParamsBase() != null) {
            if (getSelectParams() != null || getTop() != null)
                sb.append("&");

            sb.append(getFilterParamsBase().getFilterParamsAsString());
        }

        return sb.toString();
    }

    public SelectParamsBase getSelectParams() {
        return selectParams;
    }

    public void setSelectParams(SelectParamsBase selectParams) {
        this.selectParams = selectParams;
    }

    public String getTop() {
        if (top == null || top == 0)
            return null;

        return "$top=" + String.valueOf(top);
    }

    public void setTop(Integer parameter) {
        this.top = parameter;
    }

    public FilterParamsBase getFilterParamsBase() {
        return filterParamsBase;
    }

    public void setFilterParamsBase(FilterParamsBase filterParamsBase) {
        this.filterParamsBase = filterParamsBase;
    }
}
