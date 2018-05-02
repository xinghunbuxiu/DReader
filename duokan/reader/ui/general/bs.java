package com.duokan.reader.ui.general;

import android.graphics.Canvas;

final class bs implements bt {
    final /* synthetic */ DotProgressBar a;

    private bs(DotProgressBar dotProgressBar) {
        this.a = dotProgressBar;
    }

    public void a(Canvas canvas) {
        float paddingLeft = ((float) this.a.getPaddingLeft()) + this.a.h;
        this.a.a(canvas, false, paddingLeft, 0, Math.min(this.a.m + 1, this.a.g));
        this.a.a(canvas, true, paddingLeft, this.a.m + 1, this.a.g);
    }
}
