package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

import java.util.Map;

class ev implements Runnable {
    final /* synthetic */ ag a;
    final /* synthetic */ Map b;
    final /* synthetic */ ej c;

    ev(ej ejVar, ag agVar, Map map) {
        this.c = ejVar;
        this.a = agVar;
        this.b = map;
    }

    public void run() {
        if (this.a != null) {
            this.a.a(this.b);
        }
    }
}
