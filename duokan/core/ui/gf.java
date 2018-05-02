package com.duokan.core.ui;

import android.graphics.Canvas;

public class gf extends ev {
    final /* synthetic */ ZoomView a;

    public gf(ZoomView zoomView) {
        this.a = zoomView;
        super(zoomView);
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
        super.a(scrollState, scrollState2);
        if (scrollState2 == ScrollState.DRAG) {
            this.a.b.a(this.a.p);
            this.a.b.b(this.a.q);
        }
    }

    protected void a(Canvas canvas) {
        super.draw(canvas);
    }

    protected void a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}
