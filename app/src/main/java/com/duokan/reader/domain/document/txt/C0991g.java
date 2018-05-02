package com.duokan.reader.domain.document.txt;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

/* renamed from: com.duokan.reader.domain.document.txt.g */
class C0991g implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0990f f4968a;

    C0991g(C0990f c0990f) {
        this.f4968a = c0990f;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f4968a.invalidateSelf();
    }
}
