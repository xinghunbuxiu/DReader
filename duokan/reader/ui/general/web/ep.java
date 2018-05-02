package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ep implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ PageController b;

    ep(PageController cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        if (this.b.pageController.mHasBar == null || this.b.pageController.mHasBar.booleanValue() != this.a) {
            this.b.pageController.mHasBar = Boolean.valueOf(this.a);
            this.b.pageController.updateBarStatus();
        }
    }
}
