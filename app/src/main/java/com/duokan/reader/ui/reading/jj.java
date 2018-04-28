package com.duokan.reader.ui.reading;

import android.view.ViewTreeObserver.OnPreDrawListener;

class jj implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ FixedPageClipView f10437a;
    /* renamed from: b */
    final /* synthetic */ ji f10438b;

    jj(ji jiVar, FixedPageClipView fixedPageClipView) {
        this.f10438b = jiVar;
        this.f10437a = fixedPageClipView;
    }

    public boolean onPreDraw() {
        this.f10438b.m14475d();
        this.f10438b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
