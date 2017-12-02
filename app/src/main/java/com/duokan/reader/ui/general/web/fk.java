package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fk implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ fj f;

    fk(fj fjVar, String str, String str2, String str3, String str4, String str5) {
        this.f = fjVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public void a() {
        this.f.b.b.js_showDialog(this.a, this.b, this.c, this.d, new fl(this), new fm(this));
    }
}
