package tr.com.hurriyet.sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import tr.com.hurriyet.opensourcesdk.services.RequestGenerator;
import tr.com.hurriyet.opensourcesdk.exceptions.InvalidApiKeyException;
import tr.com.hurriyet.opensourcesdk.exceptions.UninitializedSdkException;
import tr.com.hurriyet.opensourcesdk.extraparams.FilterOperation;
import tr.com.hurriyet.opensourcesdk.extraparams.filterenums.WriterListFilterEnum;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.WriterListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectenum.WriterListSelectEnum;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.WriterListSelectParams;
import tr.com.hurriyet.opensourcesdk.model.ErrorModel;
import tr.com.hurriyet.opensourcesdk.model.response.Writer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSdk();
    }

    private void initializeSdk() {
        try {
            // Initialize sdk safely
            RequestGenerator.initialize(getApplicationContext(), Constants.API_KEY);
        } catch (InvalidApiKeyException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            RequestGenerator.get().registerAsResponseHandler(this);
        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
        launchRequests();
    }

    @Override
    protected void onPause() {
        try {
            RequestGenerator.get().unregisterAsResponseHandler(this);
        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    private void launchRequests() {
        try {
            // Get request generator instance safely
            RequestGenerator requestBuilder = RequestGenerator.get();

            // Generate write request

            //Generate a select params object
            WriterListSelectParams selectParams = new WriterListSelectParams(WriterListSelectEnum.Id
                    , WriterListSelectEnum.Url
                    , WriterListSelectEnum.Fullname
                    , WriterListSelectEnum.ContentType);

            // Generate a filter params object
            WriterListFilterParams filterParams = new WriterListFilterParams();
            filterParams.addFilterParam(WriterListFilterEnum.Path, FilterOperation.EQUAL, "/yazarlar/");

//            requestBuilder.writerListRequest(filterParams, selectParams, 5);
            requestBuilder.writerListRequest(null, null, 12);

        } catch (UninitializedSdkException e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void onWriterListRespone(Writer[] response) {
        Toast.makeText(getApplicationContext(), "" + response[0].fullname, Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void onError(ErrorModel errorModel) {
        // TODO handle the error.
    }
}
