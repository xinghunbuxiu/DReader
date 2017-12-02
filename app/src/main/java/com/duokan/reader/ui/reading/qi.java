package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.document.as;

class qi implements Callback {
    final /* synthetic */ qh a;

    qi(qh qhVar) {
        this.a = qhVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.a.c.U() == PageAnimationMode.VSCROLL) {
            this.a.e.getPagesFrameView().invalidate();
            return;
        }
        as aa = this.a.c.aa();
        if (aa != null) {
            aa.invalidateSelf();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        t.b(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        t.c(runnable);
    }
}
