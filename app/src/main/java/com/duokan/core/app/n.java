package com.duokan.core.app;

import android.content.Context;
import android.view.OrientationEventListener;

import com.duokan.core.ui.dv;

class n extends OrientationEventListener {
    final /* synthetic */ m a;

    n(m mVar, Context context, int i) {
        this.a = mVar;
        super(context, i);
    }

    public void onOrientationChanged(int i) {
        if (i >= 0 && i < 360 && Math.abs(this.a.h - i) >= 75) {
            int i2 = i < 45 ? 0 : i < 135 ? 90 : i < 225 ? 180 : i < 315 ? 270 : 0;
            this.a.h = i2;
            i2 = this.a.h - dv.a((-this.a.getWindowManager().getDefaultDisplay().getRotation()) * 90, 0, 360);
            if (this.a.i != i2) {
                this.a.i = i2;
                this.a.notifyScreenRotationChanged(this.a.i);
            }
        }
    }
}
