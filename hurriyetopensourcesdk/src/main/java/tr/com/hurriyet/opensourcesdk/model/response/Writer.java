package tr.com.hurriyet.opensourcesdk.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by austa on 21/12/2016.
 */

public class Writer {

    @SerializedName("Id")
    public String id;

    @SerializedName("Fullname")
    public String fullname;

    @SerializedName("ContentType")
    public String contentType;

    @SerializedName("CreatedDate")
    public String createdDate;

    @SerializedName("Files")
    public ArrayList<File> files;

    @SerializedName("Path")
    public String path;

    @SerializedName("Url")
    public String url;

}
