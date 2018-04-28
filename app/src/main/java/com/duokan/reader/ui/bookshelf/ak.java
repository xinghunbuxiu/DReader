package com.duokan.reader.ui.bookshelf;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.core.sys.UThread;

class ak implements Callback {
    /* renamed from: a */
    final /* synthetic */ aj f6114a;

    ak(aj ajVar) {
        this.f6114a = ajVar;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UThread.removeCallbacks(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UThread.postDelayed(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f6114a.invalidateSelf();
    }
}
