package com.duokan.reader.ui;

import com.duokan.core.app.aa;
import com.duokan.core.app.k;

public interface e extends aa, k {
    boolean pushPage(com.duokan.core.app.e eVar);

    boolean pushPageSmoothly(com.duokan.core.app.e eVar, Runnable runnable);

    boolean showPopup(com.duokan.core.app.e eVar);

    boolean showPopup(com.duokan.core.app.e eVar, int i, int i2);

    boolean showPopupSmoothly(com.duokan.core.app.e eVar, Runnable runnable);
}
