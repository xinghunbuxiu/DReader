package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.document.as;

class qs implements Callback {
    /* renamed from: a */
    final /* synthetic */ qr f10872a;

    qs(qr qrVar) {
        this.f10872a = qrVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f10872a.f9279c.mo2004U() == PageAnimationMode.VSCROLL) {
            this.f10872a.f9281e.getPagesFrameView().invalidate();
            return;
        }
        as aa = this.f10872a.f9279c.aa();
        if (aa != null) {
            aa.invalidateSelf();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        UThread.postAtTime(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        UThread.removeCallbacks(runnable);
    }
}
