package com.podo.weidong.core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 项目配置类
 */

public class Configurator {
    //    项目配置缓存
    private static final HashMap<String, Object> APP_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList();

    private Configurator() {
        //默认没有配置
        APP_CONFIGS.put(ConfigType.CONFIG_SUCCESS.name(), false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    //得到配置项
    final HashMap<String, Object> getAppConfigs() {
        return APP_CONFIGS;
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    //完成配置
    public final void configure() {
        initIcons();
        APP_CONFIGS.put(ConfigType.CONFIG_SUCCESS.name(), true);
    }

    public final Configurator withApiHost(String host) {
        APP_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    //检查是否配置完成
    private void checkConfigureation() {
        final boolean isSuccess = (boolean) APP_CONFIGS.get(ConfigType.CONFIG_SUCCESS);
        if (!isSuccess) {
            throw new RuntimeException("Configuration is not success");
        }
    }

    private void initIcons() {
        if (!ICONS.isEmpty()) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }

    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    // 获取配置项内容
    final <T> T getConfiguration(Enum<ConfigType> type) {
        checkConfigureation();
        final Object value = APP_CONFIGS.get(type.name());
        if (value == null) {
            throw new NullPointerException(type.toString() + " IS NULL");
        }
        return (T) value;
    }
}
