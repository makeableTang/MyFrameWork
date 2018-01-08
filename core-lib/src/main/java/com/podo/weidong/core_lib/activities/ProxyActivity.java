package com.podo.weidong.core_lib.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.podo.weidong.core_lib.FramentHolder.SecondaryFragment;
import com.podo.weidong.core_lib.R;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * acitvity 基类
 */

public abstract class ProxyActivity extends SupportActivity {
    public static final String TAG = ProxyActivity.class.getName();

    public abstract SecondaryFragment setRootFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout contentFrameLayout = new ContentFrameLayout(this);
        contentFrameLayout.setId(R.id.content_frame_layout_id);
        setContentView(contentFrameLayout);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.content_frame_layout_id, setRootFragment());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
