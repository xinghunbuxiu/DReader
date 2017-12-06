package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.ui.UTools;

class eb implements as {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ PageController d;

    eb(PageController cgVar, int i, int i2, boolean z) {
        this.d = cgVar;
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public void a() {
        this.d.pageController.scrollPosToTop(UTools.getMinimumHeight(this.d.pageController.getContext(), (float) this.a), UTools.getMinimumHeight(this.d.pageController.getContext(), (float) this.b), this.c);
    }
}
