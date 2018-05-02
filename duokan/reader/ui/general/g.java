package com.duokan.reader.ui.general;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.TaskHandler;

class g implements Callback {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        TaskHandler.removeCallbacks(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        TaskHandler.postDelayed(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }
}
