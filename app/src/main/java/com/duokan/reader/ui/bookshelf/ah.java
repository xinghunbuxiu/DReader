package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class ah implements Callback {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.a.unscheduleSelf(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.a.scheduleSelf(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }
}
