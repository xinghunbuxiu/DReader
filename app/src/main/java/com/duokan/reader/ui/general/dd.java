package com.duokan.reader.ui.general;

import android.graphics.Rect;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bh;
import com.duokan.reader.ui.general.FlowPagesView.FlipEffect;

class dd extends bh {
    /* renamed from: a */
    final /* synthetic */ dc f7056a;

    dd(dc dcVar) {
        this.f7056a = dcVar;
        super(dcVar);
    }

    /* renamed from: a */
    protected void mo501a(float f, float f2) {
        if (this.f7056a.f7055a.m10028p()) {
            super.mo501a(f, f2);
        } else if (this.f7056a.f7055a.f6858k != FlipEffect.FADE_IN && this.f7056a.f7055a.f6858k != FlipEffect.NONE) {
            super.mo501a(f, f2);
            if (Float.compare((float) getViewportBounds().left, (float) this.f7056a.f7055a.m10097f(0)) != 0 || !this.f7056a.f7055a.getCurrentPagePresenter().mo2329e()) {
                return;
            }
            if (this.f7056a.f7055a.m10084c((int) (-f)) && this.f7056a.f7055a.getProxyAdapter().mo1765b().mo2320a(this.f7056a.f7055a.getCurrentPagePresenter())) {
                this.f7056a.f7055a.m10023k();
            } else if (this.f7056a.f7055a.m10089d((int) (-f)) && this.f7056a.f7055a.getProxyAdapter().mo1765b().mo2322b(this.f7056a.f7055a.getCurrentPagePresenter())) {
                this.f7056a.f7055a.m10024l();
            }
        }
    }

    /* renamed from: b */
    protected void mo1761b(ScrollState scrollState, float f, float f2) {
        if (this.f7056a.f7055a.m10028p()) {
            super.mo1761b(scrollState, f, f2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        if (scrollState != ScrollState.IDLE) {
            return;
        }
        int e;
        if (this.f7056a.f7055a.m10090d(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(1);
            m1481a(this.f7056a.f7055a.m9984a(0.0f, e), 0.0f, e, e, 0, 0, null, null);
        } else if (this.f7056a.f7055a.m10085c(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(-1);
            m1481a(this.f7056a.f7055a.m9984a(0.0f, e), 0.0f, e, e, 0, 0, null, null);
        }
    }

    /* renamed from: a */
    protected void mo1768a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (this.f7056a.f7055a.m10028p()) {
            super.mo1768a(f, f2, this.f7056a.f7055a.m9983a(f3), this.f7056a.f7055a.m10003b(f4), runnable, runnable2);
            return;
        }
        int e;
        Rect viewportBounds = getViewportBounds();
        if (this.f7056a.f7055a.m10089d((int) (-f3)) && !this.f7056a.f7055a.m10085c(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(1);
        } else if (!this.f7056a.f7055a.m10084c((int) (-f3)) || this.f7056a.f7055a.m10090d(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(0);
        } else {
            e = this.f7056a.f7055a.m10097f(-1);
        }
        if (this.f7056a.f7055a.f6858k == FlipEffect.NONE) {
            super.mo1759a((float) (e - getViewportBounds().left), 0.0f, 0, false, runnable, runnable2);
            return;
        }
        super.m1482a(this.f7056a.f7055a.m9984a(-f3, e), f4, e, e, runnable, runnable2);
    }

    /* renamed from: a */
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        if (this.f7056a.f7055a.m10028p()) {
            super.mo1694a(f, f2, runnable, runnable2);
            return;
        }
        int e;
        Rect viewportBounds = getViewportBounds();
        if (this.f7056a.f7055a.m10089d((int) f) && this.f7056a.f7055a.m10090d(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(1);
        } else if (this.f7056a.f7055a.m10084c((int) f) && this.f7056a.f7055a.m10085c(viewportBounds)) {
            e = this.f7056a.f7055a.m10097f(-1);
        } else {
            e = this.f7056a.f7055a.m10097f(0);
        }
        super.m1481a(this.f7056a.f7055a.m9984a(f, e), f2, e, e, 0, 0, runnable, runnable2);
    }

    /* renamed from: a */
    protected void mo1759a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (this.f7056a.f7055a.m10028p()) {
            super.mo1759a(f, f2, i, z, runnable, runnable2);
        } else {
            super.mo1759a(f, f2, this.f7056a.f7055a.f6858k == FlipEffect.NONE ? 0 : i, z, runnable, runnable2);
        }
    }

    protected int ab() {
        return super.ab() + 1;
    }
}
