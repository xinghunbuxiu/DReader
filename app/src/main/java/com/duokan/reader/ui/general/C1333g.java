package com.duokan.reader.ui.general;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.ui.general.g */
class C1333g implements Callback {
    /* renamed from: a */
    final /* synthetic */ C1332f f7267a;

    C1333g(C1332f c1332f) {
        this.f7267a = c1332f;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UThread.removeCallbacks(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UThread.postDelayed(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f7267a.invalidateSelf();
    }
}
