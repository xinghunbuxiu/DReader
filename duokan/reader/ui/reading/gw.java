package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class gw implements Callback {
    final /* synthetic */ gs a;

    private gw(gs gsVar) {
        this.a = gsVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.a.m != null) {
            this.a.m.getChildAt(0).invalidate();
        }
        this.a.invalidate();
        this.a.e.invalidate();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}
