package com.podo.weidong.core.net.callback;

/**
 * 网络错误回调
 */

public interface IError {

    void onError(int code, String msg);
}
