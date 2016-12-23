package tr.com.hurriyet.opensourcesdk.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by austa on 21/12/2016.
 */

public class Page {

    @SerializedName("Id")
    public String id;

    @SerializedName("CreatedDate")
    public String createdDate;

    @SerializedName("RelatedNews")
    public ArrayList<Object> relatedNews;

    @SerializedName("Title")
    public String title;

    @SerializedName("Url")
    public String url;

}
