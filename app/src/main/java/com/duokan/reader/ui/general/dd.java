package com.duokan.reader.ui.general;

import android.graphics.Rect;

import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bh;
import com.duokan.reader.ui.general.FlowPagesView.FlipEffect;

class dd extends bh {
    final /* synthetic */ dc a;

    dd(dc dcVar) {
        this.a = dcVar;
        super(dcVar);
    }

    protected void a(float f, float f2) {
        if (this.a.a.p()) {
            super.a(f, f2);
        } else if (this.a.a.k != FlipEffect.FADE_IN && this.a.a.k != FlipEffect.NONE) {
            super.a(f, f2);
            if (Float.compare((float) getViewportBounds().left, (float) this.a.a.f(0)) != 0 || !this.a.a.getCurrentPagePresenter().e()) {
                return;
            }
            if (this.a.a.c((int) (-f)) && this.a.a.getProxyAdapter().b().a(this.a.a.getCurrentPagePresenter())) {
                this.a.a.k();
            } else if (this.a.a.d((int) (-f)) && this.a.a.getProxyAdapter().b().b(this.a.a.getCurrentPagePresenter())) {
                this.a.a.l();
            }
        }
    }

    protected void b(ScrollState scrollState, float f, float f2) {
        if (this.a.a.p()) {
            super.b(scrollState, f, f2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        if (scrollState != ScrollState.IDLE) {
            return;
        }
        int e;
        if (this.a.a.d(viewportBounds)) {
            e = this.a.a.f(1);
            a(this.a.a.a(0.0f, e), 0.0f, e, e, 0, 0, null, null);
        } else if (this.a.a.c(viewportBounds)) {
            e = this.a.a.f(-1);
            a(this.a.a.a(0.0f, e), 0.0f, e, e, 0, 0, null, null);
        }
    }

    protected void a(float f, float f2, float f3, float f4, Runnable runnable, Runnable runnable2) {
        if (this.a.a.p()) {
            super.a(f, f2, this.a.a.a(f3), this.a.a.b(f4), runnable, runnable2);
            return;
        }
        int e;
        Rect viewportBounds = getViewportBounds();
        if (this.a.a.d((int) (-f3)) && !this.a.a.c(viewportBounds)) {
            e = this.a.a.f(1);
        } else if (!this.a.a.c((int) (-f3)) || this.a.a.d(viewportBounds)) {
            e = this.a.a.f(0);
        } else {
            e = this.a.a.f(-1);
        }
        if (this.a.a.k == FlipEffect.NONE) {
            super.a((float) (e - getViewportBounds().left), 0.0f, 0, false, runnable, runnable2);
            return;
        }
        super.a(this.a.a.a(-f3, e), f4, e, e, runnable, runnable2);
    }

    protected void a(float f, float f2, Runnable runnable, Runnable runnable2) {
        if (this.a.a.p()) {
            super.a(f, f2, runnable, runnable2);
            return;
        }
        int e;
        Rect viewportBounds = getViewportBounds();
        if (this.a.a.d((int) f) && this.a.a.d(viewportBounds)) {
            e = this.a.a.f(1);
        } else if (this.a.a.c((int) f) && this.a.a.c(viewportBounds)) {
            e = this.a.a.f(-1);
        } else {
            e = this.a.a.f(0);
        }
        super.a(this.a.a.a(f, e), f2, e, e, 0, 0, runnable, runnable2);
    }

    protected void a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (this.a.a.p()) {
            super.a(f, f2, i, z, runnable, runnable2);
        } else {
            super.a(f, f2, this.a.a.k == FlipEffect.NONE ? 0 : i, z, runnable, runnable2);
        }
    }

    protected int ab() {
        return super.ab() + 1;
    }
}
