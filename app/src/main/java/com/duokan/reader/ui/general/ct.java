package com.duokan.reader.ui.general;

import android.graphics.Rect;
import android.graphics.RectF;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bh;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class ct extends bh {
    /* renamed from: a */
    final /* synthetic */ cs f7047a;

    ct(cs csVar) {
        this.f7047a = csVar;
        super(csVar);
    }

    /* renamed from: a */
    protected void mo503a(ScrollState scrollState, RectF rectF) {
        if (this.f7047a.f7046b.getPageScaleType() != PageScaleType.MATCH_WIDTH && scrollState == ScrollState.IDLE && this.f7047a.f7046b.getCurrPageIndex() >= 0) {
            RectF c = this.f7047a.f7046b.m10036a(this.f7047a.f7046b.getCurrPageIndex(), rectF.width(), rectF.height());
            rectF.offset(Math.max(c.left, Math.min(rectF.left, c.right - rectF.width())) - rectF.left, Math.max(c.top, Math.min(rectF.top, c.bottom - rectF.height())) - rectF.top);
        }
    }

    /* renamed from: a */
    protected void mo1760a(ScrollState scrollState, float f, float f2) {
        this.f7047a.f7046b.f6846k = this.f7047a.f7046b.getCurrPageIndex();
    }

    /* renamed from: a */
    protected void mo501a(float f, float f2) {
        this.f7047a.f7046b.f6847l.offset((int) f, (int) f2);
        super.mo501a(f, f2);
    }

    /* renamed from: b */
    protected void mo1761b(ScrollState scrollState, float f, float f2) {
        this.f7047a.f7046b.f6846k = -1;
        this.f7047a.f7046b.f6847l.set(0, 0);
    }

    /* renamed from: a */
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        if (this.f7047a.f7046b.getPageScaleType() == PageScaleType.MATCH_WIDTH) {
            super.mo1694a(this.f7047a.f7046b.m9983a(f), this.f7047a.f7046b.m10003b(f2), runnable, runnable2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        int i;
        if (this.f7047a.f7046b.f6846k < this.f7047a.f7046b.getPageCount() - 1 && this.f7047a.f7046b.m10043b(this.f7047a.f7046b.f6846k)) {
            i = this.f7047a.f7046b.m10034a(this.f7047a.f7046b.f6846k + 1, viewportBounds.width(), getViewportBounds().height()).left;
            super.m1481a(this.f7047a.f7046b.m9984a(f, i), f2, i, i, mo504b(), an(), runnable, runnable2);
        } else if (this.f7047a.f7046b.f6846k <= 0 || !this.f7047a.f7046b.mo2015a(this.f7047a.f7046b.f6846k)) {
            Rect a = this.f7047a.f7046b.m10034a(this.f7047a.f7046b.f6846k, viewportBounds.width(), getViewportBounds().height());
            super.m1481a(this.f7047a.f7046b.m9983a(f), this.f7047a.f7046b.m10003b(f2), a.left, a.right - viewportBounds.width(), mo504b(), an(), runnable, runnable2);
        } else {
            i = this.f7047a.f7046b.m10034a(this.f7047a.f7046b.f6846k - 1, viewportBounds.width(), getViewportBounds().height()).right - viewportBounds.width();
            super.m1481a(this.f7047a.f7046b.m9984a(f, i), f2, i, i, mo504b(), an(), runnable, runnable2);
        }
    }

    /* renamed from: a */
    protected void mo1759a(float f, float f2, int i, boolean z, Runnable runnable, Runnable runnable2) {
        if (this.f7047a.f7046b.getPageScaleType() == PageScaleType.MATCH_WIDTH) {
            super.mo1759a(f, f2, i, z, runnable, runnable2);
            return;
        }
        Rect viewportBounds = getViewportBounds();
        Rect a = this.f7047a.f7046b.m10034a(this.f7047a.f7046b.getCurrPageIndex(), viewportBounds.width(), viewportBounds.height());
        if (f <= 0.0f || this.f7047a.f7046b.getCurrPageIndex() >= this.f7047a.f7046b.getPageCount() - 1) {
            if (f >= 0.0f || this.f7047a.f7046b.getCurrPageIndex() <= 0) {
                super.mo1759a(f, f2, i, z, runnable, runnable2);
            } else if (viewportBounds.left == a.left) {
                super.mo1759a((float) ((this.f7047a.f7046b.m10034a(this.f7047a.f7046b.getCurrPageIndex() - 1, viewportBounds.width(), viewportBounds.height()).right - viewportBounds.width()) - viewportBounds.left), f2, i, z, runnable, runnable2);
            } else {
                super.mo1759a(Math.max(f, (float) (a.left - viewportBounds.left)), f2, i, z, runnable, runnable2);
            }
        } else if (viewportBounds.right == a.right) {
            super.mo1759a((float) (this.f7047a.f7046b.m10034a(this.f7047a.f7046b.getCurrPageIndex() + 1, viewportBounds.width(), viewportBounds.height()).left - viewportBounds.left), f2, i, z, runnable, runnable2);
        } else {
            super.mo1759a(Math.min(f, (float) ((a.right - viewportBounds.width()) - viewportBounds.left)), f2, i, z, runnable, runnable2);
        }
    }
}
