package com.duokan.reader.ui.reading;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class agl implements Callback {
    /* renamed from: a */
    final /* synthetic */ agh f9762a;

    agl(agh agh) {
        this.f9762a = agh;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f9762a.m13689n().setDisplay(this.f9762a.f9742j.getHolder());
        this.f9762a.m13688m();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }
}
