package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class jc implements Callback {
    final /* synthetic */ FixedPageClipView a;
    final /* synthetic */ jb b;

    jc(jb jbVar, FixedPageClipView fixedPageClipView) {
        this.b = jbVar;
        this.a = fixedPageClipView;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.b.invalidate();
    }
}
