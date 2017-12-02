package com.duokan.reader.ui.general;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.t;

class ha implements Callback {
    final /* synthetic */ PicView a;

    ha(PicView picView) {
        this.a = picView;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        t.c(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        t.a(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidate();
    }
}
