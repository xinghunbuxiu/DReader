package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bg implements Callback {
    /* renamed from: a */
    final /* synthetic */ bf f6162a;

    bg(bf bfVar) {
        this.f6162a = bfVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f6162a.unscheduleSelf(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f6162a.scheduleSelf(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f6162a.invalidateSelf();
    }
}
