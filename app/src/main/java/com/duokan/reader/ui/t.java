package com.duokan.reader.ui;

import com.duokan.core.app.ActivatedController;

public interface t extends ActivatedController {
    boolean pushHalfPage(ActivatedController activatedControllerVar);

    boolean pushHalfPageSmoothly(ActivatedController activatedControllerVar, Runnable runnable);
}
