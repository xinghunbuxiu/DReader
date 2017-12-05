package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ir implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ iq d;

    ir(iq iqVar, String str, String str2, boolean z) {
        this.d = iqVar;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public void a() {
        this.d.b.pageController.js_showWeb(this.a, this.d.b.pageController.handleUrl(this.b), this.c);
    }
}
