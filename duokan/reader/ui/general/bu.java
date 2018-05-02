package com.duokan.reader.ui.general;

import android.graphics.Canvas;

final class bu implements bt {
    final /* synthetic */ DotProgressBar a;

    private bu(DotProgressBar dotProgressBar) {
        this.a = dotProgressBar;
    }

    public void a(Canvas canvas) {
        float paddingLeft = ((float) this.a.getPaddingLeft()) + this.a.h;
        this.a.a(canvas, true, paddingLeft, 0, this.a.m);
        this.a.a(canvas, false, paddingLeft, this.a.m, this.a.m + 1);
        this.a.a(canvas, true, paddingLeft, this.a.m + 1, this.a.g);
    }
}
