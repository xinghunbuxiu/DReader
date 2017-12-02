package com.duokan.reader.ui.reading;

import android.view.ViewTreeObserver.OnPreDrawListener;

class iz implements OnPreDrawListener {
    final /* synthetic */ FixedPageClipView a;
    final /* synthetic */ iy b;

    iz(iy iyVar, FixedPageClipView fixedPageClipView) {
        this.b = iyVar;
        this.a = fixedPageClipView;
    }

    public boolean onPreDraw() {
        this.b.d();
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
