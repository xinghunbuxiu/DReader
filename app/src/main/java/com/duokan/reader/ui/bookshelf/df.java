package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.core.sys.UThread;

class df implements Callback {
    /* renamed from: a */
    final /* synthetic */ de f6329a;

    df(de deVar) {
        this.f6329a = deVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UThread.removeCallbacks(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UThread.postAtTime(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f6329a.invalidate();
    }
}
