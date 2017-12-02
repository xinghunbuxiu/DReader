package com.duokan.reader.ui.general;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.t;

class g implements Callback {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        t.c(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        t.a(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }
}
