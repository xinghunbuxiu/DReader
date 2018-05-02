package com.duokan.reader.ui;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.FeatureListening;
import com.duokan.core.app.ab;

/* renamed from: com.duokan.reader.ui.e */
public interface C0436e extends ab, FeatureListening {
    boolean pushPage(ActivatedController c0303e);

    boolean pushPageSmoothly(ActivatedController c0303e, Runnable runnable);

    boolean showPopup(ActivatedController c0303e);

    boolean showPopup(ActivatedController c0303e, int i, int i2);

    boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable);
}
