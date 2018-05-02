package com.duokan.reader.domain.document.epub;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: com.duokan.reader.domain.document.epub.j */
class C0943j implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0942i f4709a;

    C0943j(C0942i c0942i) {
        this.f4709a = c0942i;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f4709a.invalidateSelf();
    }
}
