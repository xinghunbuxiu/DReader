package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ci implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ cg b;

    ci(cg cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        this.b.b.mJsPageLoading = this.a;
        this.b.a(new cj(this));
    }
}
