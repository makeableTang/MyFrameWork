package com.podo.weidong.mydemosh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.podo.weidong.core.FramentHolder.SecondaryFragment;
import com.podo.weidong.core.activities.ProxyActivity;
import com.podo.weidong.net.RestClient;
import com.podo.weidong.net.callback.ISuccess;

public class MainActivity extends ProxyActivity {
    public static final String TAG = MainActivity.class.getName();


    @Override
    public SecondaryFragment setRootFragment() {
        return new MainFragment();
    }
}
