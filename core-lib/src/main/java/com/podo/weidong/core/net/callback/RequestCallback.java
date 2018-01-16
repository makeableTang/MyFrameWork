package com.podo.weidong.core.net.callback;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/15 0015.
 */

public class RequestCallback implements Callback<String> {
    private static final String TAG = RequestCallback.class.getName();
    private ISuccess mSuccess;
    private IRequest mRequest;
    private IFailure mFailure;
    private IError mError;

    public RequestCallback(ISuccess mSuccess, IRequest mRequest, IFailure mFailure, IError mError) {
        this.mSuccess = mSuccess;
        this.mRequest = mRequest;
        this.mFailure = mFailure;
        this.mError = mError;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (mSuccess != null) {
                    mSuccess.onSuccess(response.body());
                } else {
                    Log.i(TAG, "onResponse: mSuccess is null");
                }
            }

        } else {
            if (mError != null) {
                mError.onError(response.code(), response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (mFailure != null) {
            mFailure.onFailure();
        }
        if (mRequest != null) {
            mRequest.onRequestEnd();
        }
    }


}
