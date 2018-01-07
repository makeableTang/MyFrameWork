package com.podo.weidong.ec_lib.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by Administrator on 2018/1/7 0007.
 */

public enum IconFont implements Icon {
    icon_scan('\ue7a0'),
    icon_eamile('\ue624'),
    icon_wx_pay('\ue79c');

    private char character;

    IconFont(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
