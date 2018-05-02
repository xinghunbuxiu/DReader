package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.account.ap;

class hx implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String[] e;
    final /* synthetic */ String[] f;
    final /* synthetic */ hw g;

    hx(hw hwVar, String str, String str2, String str3, String str4, String[] strArr, String[] strArr2) {
        this.g = hwVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = strArr;
        this.f = strArr2;
    }

    public void a() {
        if (this.g.b.pageController.mShareController != null) {
            this.g.b.pageController.deactivate(this.g.b.pageController.mShareController);
            this.g.b.pageController.removeSubController(this.g.b.pageController.mShareController);
        }
        new ap(this.g.b.pageController.getContext(), false, new hy(this)).show();
    }
}
