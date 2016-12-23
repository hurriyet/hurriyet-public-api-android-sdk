package tr.com.hurriyet.opensourcesdk.services;

import android.util.Log;

import tr.com.hurriyet.opensourcesdk.extraparams.FilterParamsBase;
import tr.com.hurriyet.opensourcesdk.model.request.ArticleRequest;
import tr.com.hurriyet.opensourcesdk.model.request.ColumnRequest;
import tr.com.hurriyet.opensourcesdk.model.request.GalleryRequest;
import tr.com.hurriyet.opensourcesdk.model.request.PageRequest;
import tr.com.hurriyet.opensourcesdk.model.request.PathRequest;
import tr.com.hurriyet.opensourcesdk.model.request.WriterRequest;
import tr.com.hurriyet.opensourcesdk.model.response.Article;
import tr.com.hurriyet.opensourcesdk.model.response.Column;
import tr.com.hurriyet.opensourcesdk.model.response.Gallery;
import tr.com.hurriyet.opensourcesdk.model.response.Page;
import tr.com.hurriyet.opensourcesdk.model.response.Path;
import tr.com.hurriyet.opensourcesdk.model.response.Writer;
import tr.com.hurriyet.opensourcesdk.extraparams.SelectParamsBase;

/**
 * Created by austa on 16/12/2016.
 */

public final class RequestBuilder {

    /**
     * Article list request
     */
    protected static GsonRequest<Article[]> articleList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        ArticleRequest articleRequest = new ArticleRequest();


        return generateGsonRequest(ServiceMethod.ARTICLE, selectParams, top, filterParams, articleRequest, Article[].class);
    }

    /**
     * Article detail request
     */
    protected static GsonRequest<Article> articleDetail(String id, SelectParamsBase selectParams) {
        ArticleRequest articleRequest = new ArticleRequest();

        return generateGsonRequest(ServiceMethod.ARTICLE, id, selectParams, articleRequest, Article.class);
    }

    /**
     * Column list request
     */
    protected static GsonRequest<Column[]> columnList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        ColumnRequest columnRequest = new ColumnRequest();

        return generateGsonRequest(ServiceMethod.COLUMN, selectParams, top, filterParams, columnRequest, Column[].class);
    }

    /**
     * Column detail request
     */
    protected static GsonRequest<Column> columnDetail(String id, SelectParamsBase selectParams) {
        ColumnRequest columnRequest = new ColumnRequest();

        return generateGsonRequest(ServiceMethod.COLUMN, id, selectParams, columnRequest, Column.class);
    }

    /**
     * gallery list request
     */
    protected static GsonRequest<Gallery[]> galleryList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        GalleryRequest galleryRequest = new GalleryRequest();

        return generateGsonRequest(ServiceMethod.PHOTOGALLERY, selectParams, top, filterParams, galleryRequest, Gallery[].class);
    }

    /**
     * gallery detail request
     */
    protected static GsonRequest<Gallery> galleryDetail(String id, SelectParamsBase selectParams) {
        GalleryRequest galleryRequest = new GalleryRequest();

        return generateGsonRequest(ServiceMethod.PHOTOGALLERY, id, selectParams, galleryRequest, Gallery.class);
    }

    /**
     * Path list request
     */
    protected static GsonRequest<Path[]> pathList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        PathRequest pathRequest = new PathRequest();

        return generateGsonRequest(ServiceMethod.PATH, selectParams, top, filterParams, pathRequest, Path[].class);
    }

    /**
     * Path detail request
     */
    protected static GsonRequest<Path> pathDetail(String id, SelectParamsBase selectParams) {
        PathRequest pathRequest = new PathRequest();

        return generateGsonRequest(ServiceMethod.PATH, id, selectParams, pathRequest, Path.class);
    }


    /**
     * Pages list request
     */
    protected static GsonRequest<Page[]> pageList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        PageRequest pageRequest = new PageRequest();

        return generateGsonRequest(ServiceMethod.PAGES, selectParams, top, filterParams, pageRequest, Page[].class);
    }

    /**
     * Pages detail request
     */
    protected static GsonRequest<Page> pageDetail(String id, SelectParamsBase selectParams) {
        PageRequest pageRequest = new PageRequest();

        return generateGsonRequest(ServiceMethod.PAGES, id, selectParams, pageRequest, Page.class);
    }

    /**
     * Writer list request
     */
    protected static GsonRequest<Writer[]> writerList(FilterParamsBase filterParams, SelectParamsBase selectParams, Integer top) {
        WriterRequest writerRequest = new WriterRequest();

        return generateGsonRequest(ServiceMethod.WRITER, selectParams, top, filterParams, writerRequest, Writer[].class);
    }

    /**
     * Writer detail request
     */
    protected static GsonRequest<Writer> writerDetail(String id, SelectParamsBase selectParams) {
        WriterRequest writerRequest = new WriterRequest();

        return generateGsonRequest(ServiceMethod.WRITER, id, selectParams, writerRequest, Writer.class);
    }

    private static <T> GsonRequest<T> generateGsonRequest(final ServiceMethod method, SelectParamsBase selectParams, Integer top, FilterParamsBase filterParamsBase, Object body, Class<T> classType) {
        GsonRequest<T> request = null;
        try {
            if (selectParams != null)
                method.setSelectParams(selectParams);

            if (top != null)
                method.setTop(top);

            if (filterParamsBase != null)
                method.setFilterParamsBase(filterParamsBase);

            request = new GsonRequest<T>(method, body, classType);
            request.setTag(method.name());
        } catch (Exception ex) {
            Log.wtf("Exception: ", ex.getMessage());
        }
        return request;
    }

    private static <T> GsonRequest<T> generateGsonRequest(final ServiceMethod method, String id, SelectParamsBase selectParams, Object body, Class<T> classType) {
        GsonRequest<T> request = null;
        try {
            if (selectParams != null)
                method.setSelectParams(selectParams);

            method.setId(id);
            request = new GsonRequest<T>(method, body, classType);
            request.setTag(method.name());
        } catch (Exception ex) {
            Log.wtf("Exception: ", ex.getMessage());
        }
        return request;
    }
}
