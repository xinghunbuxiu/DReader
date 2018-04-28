package com.duokan.reader.ui.general;

import android.graphics.Canvas;

final class bs implements bt {
    /* renamed from: a */
    final /* synthetic */ DotProgressBar f7008a;

    private bs(DotProgressBar dotProgressBar) {
        this.f7008a = dotProgressBar;
    }

    /* renamed from: a */
    public void mo1752a(Canvas canvas) {
        float paddingLeft = ((float) this.f7008a.getPaddingLeft()) + this.f7008a.f6808h;
        this.f7008a.m9969a(canvas, false, paddingLeft, 0, Math.min(this.f7008a.f6813m + 1, this.f7008a.f6807g));
        this.f7008a.m9969a(canvas, true, paddingLeft, this.f7008a.f6813m + 1, this.f7008a.f6807g);
    }
}
