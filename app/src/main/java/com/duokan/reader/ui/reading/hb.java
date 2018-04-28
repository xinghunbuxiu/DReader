package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class hb implements Callback {
    /* renamed from: a */
    final /* synthetic */ gx f10311a;

    private hb(gx gxVar) {
        this.f10311a = gxVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f10311a.f10294m != null) {
            this.f10311a.f10294m.getChildAt(0).invalidate();
        }
        this.f10311a.invalidate();
        this.f10311a.f10286e.invalidate();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }
}
