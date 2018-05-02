package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.TaskHandler;

class ae implements Callback {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
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
