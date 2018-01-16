package com.podo.weidong.core.net;

import com.podo.weidong.core.net.callback.IError;
import com.podo.weidong.core.net.callback.IFailure;
import com.podo.weidong.core.net.callback.IRequest;
import com.podo.weidong.core.net.callback.ISuccess;
import com.podo.weidong.core.net.callback.RequestCallback;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Administrator on 2018/1/15 0015.
 */

public class RestClient {
    private final String URL;
    private final ISuccess SUCCESS;
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

    public RestClient(String URL,
                      WeakHashMap<String, Object> PARAMS,
                      ISuccess SUCCESS,
                      IRequest REQUEST,
                      IFailure FAILURE,
                      IError ERROR,
                      RequestBody BODY) {
        this.URL = URL;
        PARAMS.putAll(PARAMS);
        this.SUCCESS = SUCCESS;
        this.REQUEST = REQUEST;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.BODY = BODY;
    }


    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        switch (method) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            default:
                break;

        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallback(
                SUCCESS,
                REQUEST,
                FAILURE,
                ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

}
