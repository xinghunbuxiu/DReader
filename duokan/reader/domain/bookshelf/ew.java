package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.List;
import java.util.Map;

class ew implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ List c;
    final /* synthetic */ Map d;
    final /* synthetic */ ag e;
    final /* synthetic */ ej f;

    ew(ej ejVar, boolean z, String str, List list, Map map, ag agVar) {
        this.f = ejVar;
        this.a = z;
        this.b = str;
        this.c = list;
        this.d = map;
        this.e = agVar;
    }

    public void run() {
        new ex(this).open();
    }
}
