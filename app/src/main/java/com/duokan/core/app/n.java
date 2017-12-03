package com.duokan.core.app;

import android.content.Context;
import android.view.OrientationEventListener;

import com.duokan.core.ui.UTools;

class n extends OrientationEventListener {
    final /* synthetic */ BaseActivity a;

    n(BaseActivity baseActivityVar, Context context, int i) {
        this.a = baseActivityVar;
        super(context, i);
    }

    public void onOrientationChanged(int i) {
        if (i >= 0 && i < 360 && Math.abs(this.a.h - i) >= 75) {
            int i2 = i < 45 ? 0 : i < 135 ? 90 : i < 225 ? 180 : i < 315 ? 270 : 0;
            this.a.h = i2;
            i2 = this.a.h - UTools.addAnimation((-this.a.getWindowManager().getDefaultDisplay().getRotation()) * 90, 0, 360);
            if (this.a.i != i2) {
                this.a.i = i2;
                this.a.notifyScreenRotationChanged(this.a.i);
            }
        }
    }
}
