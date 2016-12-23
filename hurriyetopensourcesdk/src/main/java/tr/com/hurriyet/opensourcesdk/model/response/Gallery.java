package tr.com.hurriyet.opensourcesdk.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by austa on 21/12/2016.
 */

public class Gallery {

    @SerializedName("Id")
    public String id;

    @SerializedName("ContentType")
    public String contentType;

    @SerializedName("CreatedDate")
    public String createdDate;

    @SerializedName("Description")
    public String description;

    @SerializedName("Files")
    public ArrayList<File> files;

    @SerializedName("ModifiedDate")
    public String modifiedDate;

    @SerializedName("Path")
    public String path;

    @SerializedName("Title")
    public String title;

    @SerializedName("Url")
    public String url;
}
