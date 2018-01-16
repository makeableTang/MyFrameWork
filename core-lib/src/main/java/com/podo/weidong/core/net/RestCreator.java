package com.podo.weidong.core.net;

import android.util.Log;

import com.podo.weidong.core.app.AppManager;
import com.podo.weidong.core.app.ConfigType;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2018/1/10 0010.
 */

public class RestCreator {
    private static final String TAG = RestCreator.class.getName();

    public RestCreator() {
    }

    /**
     * 构建全局Retrofit客户端
     */
    private static final class RetrofitHolder {
        private static final String BASE_URL = (String) AppManager.getConfiguration(ConfigType.API_HOST);

        static {
            Log.i(TAG, "static initializer: RetrofitHolder");
        }

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    /**
     * 构建全局OkHttpHolder客户端
     */
    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;

        static {
            Log.i(TAG, "static initializer: OkHttpHolder");
        }

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Service接口
     */
    private static final class RestServiceHolder {
        static {
            Log.i(TAG, "static initializer: RestServiceHolder");
        }

        private static final RestService REST_SERVICE = getRetrofitClient().create(RestService.class);
    }

    /**
     * 参数容器
     */
    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static final Retrofit getRetrofitClient() {
        Log.i(TAG, "getRetrofitClient: getRetrofitClient");
        return RetrofitHolder.RETROFIT_CLIENT;
    }

    public static final OkHttpClient getOkHttpClient() {
        return OkHttpHolder.OK_HTTP_CLIENT;
    }

    public static final RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }
}
