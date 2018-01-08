package com.podo.weidong.mydemosh;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.podo.weidong.core_lib.app.AppManager;
import com.podo.weidong.ec_lib.icon.FontEcModule;

/**
 * Created by Administrator on 2018/1/7 0007.
 */

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppManager.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("")
                .configure();
    }
}
