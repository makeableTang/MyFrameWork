package com.podo.weidong.mydemosh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.podo.weidong.core.FramentHolder.SecondaryFragment;
import com.podo.weidong.net.RestClient;
import com.podo.weidong.net.callback.ISuccess;

/**
 * Created by Administrator on 2018/1/9 0009.
 */

public class MainFragment extends SecondaryFragment {
    @Override
    public Object setLayout() {
        return R.layout.main_fragment_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootVIew) {
        RestClient.builder().url("http://blog.csdn.net/qq_16064871/article/details/54645475").success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
            }
        }).build().get();
    }
}
