package com.duokan.reader.ui;

import com.duokan.core.app.ActivatedController;


public interface PushHalfPage extends InavOperater {
    boolean pushHalfPage(ActivatedController activatedControllerVar);

    boolean pushHalfPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable);
}
