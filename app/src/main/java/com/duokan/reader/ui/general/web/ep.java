package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ep implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ cg b;

    ep(cg cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        if (this.b.b.mHasBar == null || this.b.b.mHasBar.booleanValue() != this.a) {
            this.b.b.mHasBar = Boolean.valueOf(this.a);
            this.b.b.updateBarStatus();
        }
    }
}
