package com.duokan.reader.ui;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.FeatureListening;
import com.duokan.core.app.Inavigate;

public interface InavOperater extends Inavigate, FeatureListening {
    boolean pushPage(ActivatedController activatedControllerVar);

    boolean pushPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable);

    boolean showPopup(ActivatedController activatedControllerVar);

    boolean showPopup(ActivatedController activatedControllerVar, int i, int i2);

    boolean showPopupSmoothly(ActivatedController activatedControllerVar, Runnable runnable);
}
