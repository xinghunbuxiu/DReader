package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.account.ap;

class ht implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ String i;
    final /* synthetic */ String[] j;
    final /* synthetic */ String[] k;
    final /* synthetic */ String l;
    final /* synthetic */ hs m;

    ht(hs hsVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String[] strArr, String[] strArr2, String str10) {
        this.m = hsVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = strArr;
        this.k = strArr2;
        this.l = str10;
    }

    public void a() {
        if (this.m.b.pageController.mShareController != null) {
            this.m.b.pageController.deactivate(this.m.b.pageController.mShareController);
            this.m.b.pageController.removeSubController(this.m.b.pageController.mShareController);
        }
        new ap(this.m.b.pageController.getContext(), false, new hv(this, new hu(this))).show();
    }
}
