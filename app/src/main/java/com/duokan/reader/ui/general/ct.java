package com.duokan.reader.ui.general;

import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bh;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class ct extends bh {
    final /* synthetic */ cs a;

    ct(cs csVar) {
        this.a = csVar;
        super(csVar);
    }

    protected void a(ScrollState scrollState, RectF rectF) {
        if (this.a.b.getPageScaleType() != PageScaleType.MATCH_WIDTH && scrollState == ScrollState.IDLE && this.a.b.getCurrPageIndex() >= 0) {
            RectF c = this.a.b.a(this.a.b.getCurrPageIndex(), rectF.width(), rectF.height());
            rectF.offset(Math.max(c.left, Math.min(rectF.left, c.right - rectF.width())) - rectF.left, Math.max(c.top, Math.min(rectF.top, c.bottom - rectF.height())) - rectF.top);
        }
    }

    protected void a(ScrollState scrollState, float f, float f2) {
        this.a.b.k = this.a.b.getCurrPageIndex();
    }

    protected void a(float f, float f2) {
        this.a.b.l.offset((int) f, (int) f2);
        super.a(f, f2);
    }

    protected void b(ScrollState scrollState, float f, float f2) {
        this.a.b.k = -1;
        this.a.b.l.set(0, 0);
    }

    protected void a(float f, float f2, Runnable runnable, Runnable runnable2) {
        if (this.a.b.getPageScaleType() == PageScaleType.MATCH_WIDTH) {
            super.a(this.a.b.a(f), this.a.b.b(f2), runnable, runnable2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        int i;
        if (this.a.b.k < this.a.b.getPageCount() - 1 && this.a.b.b(this.a.b.k)) {
            i = this.a.b.a(this.a.b.k + 1, viewportBounds.width(), getViewportBounds().height()).left;
            super.a(this.a.b.a(f, i), f2, i, i, b(), an(), runnable, runnable2);
        } else if (this.a.b.k <= 0 || !this.a.b.a(this.a.b.k)) {
            Rect a = this.a.b.a(this.a.b.k, viewportBounds.width(), getViewportBounds().height());
            super.a(this.a.b.a(f), this.a.b.b(f2), a.left, a.right - viewportBounds.width(), b(), an(), runnable, runnable2);
        } else {
            i = this.a.b.a(this.a.b.k - 1, viewportBounds.width(), getViewportBounds().height()).right - viewportBounds.width();
            super.a(this.a.b.a(f, i), f2, i, i, b(), an(), runnable, runnable2);
        }
    }

    protected void a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (this.a.b.getPageScaleType() == PageScaleType.MATCH_WIDTH) {
            super.a(f, f2, i, z, runnable, runnable2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        Rect a = this.a.b.a(this.a.b.getCurrPageIndex(), viewportBounds.width(), viewportBounds.height());
        if (f <= 0.0f || this.a.b.getCurrPageIndex() >= this.a.b.getPageCount() - 1) {
            if (f >= 0.0f || this.a.b.getCurrPageIndex() <= 0) {
                super.a(f, f2, i, z, runnable, runnable2);
            } else if (viewportBounds.left == a.left) {
                super.a((float) ((this.a.b.a(this.a.b.getCurrPageIndex() - 1, viewportBounds.width(), viewportBounds.height()).right - viewportBounds.width()) - viewportBounds.left), f2, i, z, runnable, runnable2);
            } else {
                super.a(Math.max(f, (float) (a.left - viewportBounds.left)), f2, i, z, runnable, runnable2);
            }
        } else if (viewportBounds.right == a.right) {
            super.a((float) (this.a.b.a(this.a.b.getCurrPageIndex() + 1, viewportBounds.width(), viewportBounds.height()).left - viewportBounds.left), f2, i, z, runnable, runnable2);
        } else {
            super.a(Math.min(f, (float) ((a.right - viewportBounds.width()) - viewportBounds.left)), f2, i, z, runnable, runnable2);
        }
    }
}
