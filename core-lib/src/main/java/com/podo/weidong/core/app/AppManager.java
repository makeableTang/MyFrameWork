package com.podo.weidong.core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * 項目配置管理類1/7 0007.
 */

public class AppManager {
    public static Configurator init(Context context) {
        getConfig().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return getConfigurator();
    }

    private static HashMap<String, Object> getConfig() {
        return Configurator.getInstance().getAppConfigs();
    }

    private static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Enum<ConfigType> type) {
        return getConfigurator().getConfiguration(type);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
}
