package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.ui.store.comment.n;

class ft implements a {
    static final /* synthetic */ boolean a = (!StorePageController.class.desiredAssertionStatus());
    final /* synthetic */ String b;
    final /* synthetic */ fs c;

    ft(fs fsVar, String str) {
        this.c = fsVar;
        this.b = str;
    }

    public void a(n nVar) {
        this.c.a.b.b.web_notifyWeb(this.b, 0, "operation", Boolean.valueOf(nVar.d), "score", Integer.valueOf(nVar.a), "title", nVar.b, "content", nVar.c);
    }

    public void a(int i, String str) {
        if (!a) {
            throw new AssertionError();
        }
    }
}
