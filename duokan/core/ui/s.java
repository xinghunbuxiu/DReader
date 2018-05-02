package com.duokan.core.ui;

import android.graphics.Canvas;

public class s extends ev {
    final /* synthetic */ FrameScrollView a;

    public s(FrameScrollView frameScrollView) {
        this.a = frameScrollView;
        super(frameScrollView);
    }

    protected void a(Canvas canvas) {
        super.draw(canvas);
    }

    protected void a(int i, int i2) {
        super.scrollTo(i, i2);
    }
}
