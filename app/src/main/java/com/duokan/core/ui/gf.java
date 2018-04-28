package com.duokan.core.ui;

import android.graphics.Canvas;
import com.duokan.core.ui.Scrollable.ScrollState;

public class gf extends ev {
    /* renamed from: a */
    final /* synthetic */ ZoomView f1294a;

    public gf(ZoomView zoomView) {
        this.f1294a = zoomView;
        super(zoomView);
    }

    /* renamed from: a */
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
        super.mo494a(scrollState, scrollState2);
        if (scrollState2 == ScrollState.DRAG) {
            this.f1294a.f870b.m1497a(this.f1294a.f884p);
            this.f1294a.f870b.m1518b(this.f1294a.f885q);
        }
    }

    /* renamed from: a */
    protected void mo492a(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: a */
    protected void mo491a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}
