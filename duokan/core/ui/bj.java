package com.duokan.core.ui;

import android.graphics.Canvas;

public class bj extends ev {
    final /* synthetic */ LinearScrollView a;

    public bj(LinearScrollView linearScrollView) {
        this.a = linearScrollView;
        super(linearScrollView);
    }

    protected void a(Canvas canvas) {
        super.draw(canvas);
    }

    protected void a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}
