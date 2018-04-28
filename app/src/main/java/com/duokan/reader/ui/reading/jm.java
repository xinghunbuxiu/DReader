package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class jm implements Callback {
    /* renamed from: a */
    final /* synthetic */ FixedPageClipView f10443a;
    /* renamed from: b */
    final /* synthetic */ jl f10444b;

    jm(jl jlVar, FixedPageClipView fixedPageClipView) {
        this.f10444b = jlVar;
        this.f10443a = fixedPageClipView;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f10444b.invalidate();
    }
}
