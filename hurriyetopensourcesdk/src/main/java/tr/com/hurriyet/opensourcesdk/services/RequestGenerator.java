package tr.com.hurriyet.opensourcesdk.services;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.otto.Bus;

import tr.com.hurriyet.opensourcesdk.exceptions.ExceptionMessages;
import tr.com.hurriyet.opensourcesdk.exceptions.InvalidApiKeyException;
import tr.com.hurriyet.opensourcesdk.exceptions.UninitializedSdkException;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.ArticleListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.ColumnListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.PageListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.PathListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.PhotoGalleryListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.filterparams.WriterListFilterParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.ArticleDetailSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.ArticleListSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.ColumnDetailSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.ColumnListSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PageDetailSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PageListSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PathDetailSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PathListSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PhotoGalleryDetailSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.PhotoGalleryListSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.WriterDetailRequestSelectParams;
import tr.com.hurriyet.opensourcesdk.extraparams.selectparams.WriterListSelectParams;

/**
 * <pre>
 * Initialize once with your applicationContext & api key.
 * Using a context other than applicationContext may cause a memory leak in some circumstances.
 *
 * You must register your response handler as well.
 * See {@link #registerAsResponseHandler(Object)} & {@link #unregisterAsResponseHandler(Object)} methods for more information.
 * <p/>
 * Created by austa on 16/12/2016.
 */

public class RequestGenerator {

    private static RequestGenerator instance;
    private Context context;
    private String apiKey;
    private RequestQueue requestQueue;
    private Bus busInstance;

    private RequestGenerator() {
    }

    /**
     * <pre>
     * Initialize sdk with the applicationContext & your api key.
     * An exception will be thrown in case one of them are invalid.
     *
     * @param applicationContext In order to prevent memory leaks, you must use your application context.
     * @param apiKey             Your api key.
     * @return The instance of generator.
     * @throws NullPointerException   Throws when the given application context is null.
     * @throws InvalidApiKeyException Throws whens the given api key is null or empty.
     */
    public static RequestGenerator initialize(Context applicationContext, String apiKey) throws NullPointerException, InvalidApiKeyException {
        if (instance != null) {
            return instance;
        }
        if (applicationContext == null) {
            throw new NullPointerException("Failed to initialize sdk. Your application context was null.");
        }
        if (TextUtils.isEmpty(apiKey)) {
            throw new NullPointerException(ExceptionMessages.InvalidApiKeyExceptionMessage + "Api key was null or empty");
        }

        instance = new RequestGenerator();
        instance.context = applicationContext;
        instance.apiKey = apiKey;
        instance.requestQueue = Volley.newRequestQueue(instance.context, new OkHttpStack());

        instance.busInstance = new Bus();
        return instance;
    }

    /**
     * <pre>
     * Register given object as response handler.
     * Subscribe a method with the desired response type to handle network responses
     * <b>Example:</b>
     * // @Subscribe public void answerAvailable(ResponseType response) {
     * //     Handle your response here
     * // }
     *
     * <a href="http://square.github.io/otto/">Check</a> Otto for more detailed information.
     * @param registerObject The object can be an activity, fragment, etc.
     */
    public void registerAsResponseHandler(Object registerObject) {
        if (busInstance == null) {
            busInstance = new Bus();
        }
        busInstance.register(registerObject);
    }

    /**
     * Un register the response handler method.
     * ( Given object will not receive any other responses until it is registered again. )
     * <p>
     * <a href="http://square.github.io/otto/">Check</a> Otto for more detailed information.
     *
     * @param registerObject The object can be an activity, fragment, etc.
     */
    public void unregisterAsResponseHandler(Object registerObject) {
        if (busInstance == null) {
            return;
        }
        busInstance.unregister(registerObject);
    }

    // =============================================================================================
    // GET METHODS

    /**
     * Get the instance of request generator.
     *
     * @return The instance that can be used to generate requests
     * @throws UninitializedSdkException Throws when the sdk is not initialized or lost its state.
     */
    public static RequestGenerator get() throws UninitializedSdkException {
        if (instance == null) {
            throw new UninitializedSdkException();
        }
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Bus getBus() {
        if (busInstance == null) {
            busInstance = new Bus();
        }
        return busInstance;
    }

    // ============================================================================================= //
    // REQUESTS - GET METHODS
    public void articleListRequest(ArticleListFilterParams filterParams, ArticleListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.articleList(filterParams, selectParams, top));
    }

    public void articleDetailRequest(String id, ArticleDetailSelectParams selectParams) {
        requestQueue.add(RequestBuilder.articleDetail(id, selectParams));
    }

    public void columnListRequest(ColumnListFilterParams filterParams, ColumnListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.columnList(filterParams, selectParams, top));
    }

    public void columnDetailRequest(String id, ColumnDetailSelectParams selectParams) {
        requestQueue.add(RequestBuilder.columnDetail(id, selectParams));
    }

    public void galleryListRequest(PhotoGalleryListFilterParams filterParams, PhotoGalleryListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.galleryList(filterParams, selectParams, top));
    }

    public void galleryDetailRequest(String id, PhotoGalleryDetailSelectParams selectParams) {
        requestQueue.add(RequestBuilder.galleryDetail(id, selectParams));
    }

    public void pageListRequest(PageListFilterParams filterParams, PageListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.pageList(filterParams, selectParams, top));
    }

    public void pageDetailRequest(String id, PageDetailSelectParams selectParams) {
        requestQueue.add(RequestBuilder.pageDetail(id, selectParams));
    }

    public void pathListRequest(PathListFilterParams filterParams, PathListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.pathList(filterParams, selectParams, top));
    }

    public void pathDetailRequest(String id, PathDetailSelectParams selectParams) {
        requestQueue.add(RequestBuilder.pathDetail(id, selectParams));
    }

    public void writerListRequest(WriterListFilterParams filterParams, WriterListSelectParams selectParams, Integer top) {
        requestQueue.add(RequestBuilder.writerList(filterParams, selectParams, top));
    }

    public void writerDetailRequest(String id, WriterDetailRequestSelectParams selectParams) {
        requestQueue.add(RequestBuilder.writerDetail(id, selectParams));
    }
}
