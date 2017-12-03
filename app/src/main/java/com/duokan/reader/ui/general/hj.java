package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

abstract class hj extends ActivatedController {
    private final ActivatedController a;
    final /* synthetic */ hd b;

    public hj(hd hdVar, IFeature featrue, ActivatedController controller) {
        this.b = hdVar;
        super(featrue);
        this.a = controller;
    }

    public final ActivatedController a() {
        return this.a;
    }

    public final View b() {
        return this.a.getContentView();
    }
}
