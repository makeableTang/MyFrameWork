package com.podo.weidong.core_lib.app;

import android.content.Context;

import java.util.HashMap;

/**
 * 項目配置管理類1/7 0007.
 */

public class AppManager {
    public static Configurator init(Context context) {
        getConfig().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfig() {
        return Configurator.getInstance().getAppConfigs();
    }

}
