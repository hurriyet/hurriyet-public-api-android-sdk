package tr.com.hurriyet.opensourcesdk.model.response;

import com.google.gson.annotations.SerializedName;

public class File {

    @SerializedName("FileUrl")
    public String fileUrl;

    @SerializedName("Metadata")
    public Metadata metadata;
}
