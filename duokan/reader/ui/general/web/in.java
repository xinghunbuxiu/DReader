package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;

class in implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ af c;
    final /* synthetic */ il d;

    in(il ilVar, String str, String str2, af afVar) {
        this.d = ilVar;
        this.a = str;
        this.b = str2;
        this.c = afVar;
    }

    public void run() {
        a.a().a(this.a, true, true, -1, -1, -1, new io(this));
    }
}
