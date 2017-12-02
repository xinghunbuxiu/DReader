package com.duokan.reader.domain.document.epub;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class j implements Callback {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }
}
