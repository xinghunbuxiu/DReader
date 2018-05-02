package com.duokan.reader.ui.reading;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class afl implements Callback {
    final /* synthetic */ afh a;

    afl(afh com_duokan_reader_ui_reading_afh) {
        this.a = com_duokan_reader_ui_reading_afh;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.n().setDisplay(this.a.j.getHolder());
        this.a.m();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }
}
