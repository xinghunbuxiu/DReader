package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.core.ui.dv;

class eb implements as {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ boolean c;
    final /* synthetic */ cg d;

    eb(cg cgVar, int i, int i2, boolean z) {
        this.d = cgVar;
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public void a() {
        this.d.b.scrollPosToTop(dv.b(this.d.b.getContext(), (float) this.a), dv.b(this.d.b.getContext(), (float) this.b), this.c);
    }
}
