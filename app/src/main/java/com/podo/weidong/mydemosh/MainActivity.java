package com.podo.weidong.mydemosh;

import android.support.v7.app.AppCompatActivity;

import com.podo.weidong.core.FramentHolder.SecondaryFragment;
import com.podo.weidong.core.activities.ProxyActivity;

public class MainActivity extends ProxyActivity {
    public static final String TAG = MainActivity.class.getName();


    @Override
    public SecondaryFragment setRootFragment() {
        return new MainFragment();
    }
}
