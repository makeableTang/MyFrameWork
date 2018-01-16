package com.podo.weidong.core.net;

import com.podo.weidong.core.net.callback.IError;
import com.podo.weidong.core.net.callback.IFailure;
import com.podo.weidong.core.net.callback.IRequest;
import com.podo.weidong.core.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/15 0015.
 */

public class RestClientBuilder {
    private String mUrl;
    private ISuccess mSuccess;
    private IRequest mRequest;
    private IFailure mFailure;
    private IError mError;
    private RequestBody mBody;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

    RestClientBuilder() {

    }

    public RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public RestClientBuilder param(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public RestClientBuilder success(ISuccess iSuccess) {
        this.mSuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mError = iError;
        return this;
    }

    public RestClient build() {
        return new RestClient(mUrl, PARAMS,
                mSuccess,
                mRequest,
                mFailure,
                mError,
                mBody);
    }
}
