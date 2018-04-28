package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class an implements Callback {
    /* renamed from: a */
    final /* synthetic */ am f6120a;

    an(am amVar) {
        this.f6120a = amVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f6120a.unscheduleSelf(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f6120a.scheduleSelf(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f6120a.invalidateSelf();
    }
}
