package com.duokan.reader.ui.general;

import android.graphics.Canvas;

final class bu implements bt {
    /* renamed from: a */
    final /* synthetic */ DotProgressBar f7009a;

    private bu(DotProgressBar dotProgressBar) {
        this.f7009a = dotProgressBar;
    }

    /* renamed from: a */
    public void mo1752a(Canvas canvas) {
        float paddingLeft = ((float) this.f7009a.getPaddingLeft()) + this.f7009a.f6808h;
        this.f7009a.m9969a(canvas, true, paddingLeft, 0, this.f7009a.f6813m);
        this.f7009a.m9969a(canvas, false, paddingLeft, this.f7009a.f6813m, this.f7009a.f6813m + 1);
        this.f7009a.m9969a(canvas, true, paddingLeft, this.f7009a.f6813m + 1, this.f7009a.f6807g);
    }
}
