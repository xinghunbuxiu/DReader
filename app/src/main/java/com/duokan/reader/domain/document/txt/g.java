package com.duokan.reader.domain.document.txt;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class g implements Callback {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }
}
