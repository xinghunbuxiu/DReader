package com.duokan.reader.ui.general;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.core.sys.UThread;

class gp implements Callback {
    /* renamed from: a */
    final /* synthetic */ PicView f7300a;

    gp(PicView picView) {
        this.f7300a = picView;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UThread.removeCallbacks(runnable);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UThread.postDelayed(runnable, j);
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f7300a.invalidate();
    }
}
