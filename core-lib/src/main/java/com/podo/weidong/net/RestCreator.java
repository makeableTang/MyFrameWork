package com.podo.weidong.net;

import com.podo.weidong.core.app.AppManager;
import com.podo.weidong.core.app.ConfigType;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class RestCreator {

    public RestCreator() {
    }

    /**
     * 构建全局Retrofit客户端
     */
    private static final class RetrofitHolder {
        private static final String BASE_URL = (String) AppManager.getConfiguration(ConfigType.API_HOST);
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    /**
     * 构建全局Retrofit客户端
     */
    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Service接口
     */
    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = getRetrofitClient().create(RestService.class);
    }

    private static final Retrofit getRetrofitClient() {
        return RetrofitHolder.RETROFIT_CLIENT;
    }

    private static final OkHttpClient getOkHttpClient() {
        return OkHttpHolder.OK_HTTP_CLIENT;
    }

    private static final RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }
}
