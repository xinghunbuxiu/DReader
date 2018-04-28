package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Iterator;

class ds extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3059a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f3060b;
    /* renamed from: c */
    final /* synthetic */ dr f3061c;

    ds(dr drVar, C0657i c0657i, al alVar, ArrayList arrayList) {
        this.f3061c = drVar;
        this.f3059a = alVar;
        this.f3060b = arrayList;
        super(c0657i);
    }

    protected void onSessionTry() {
        da daVar = new da(this.f3059a);
        daVar.m4295a();
        if (!this.f3060b.isEmpty()) {
            Iterator it = this.f3060b.iterator();
            while (it.hasNext()) {
                dd ddVar = (dd) it.next();
                if (ddVar.f3007f == 0) {
                    daVar.updateItem(ddVar);
                } else if (ddVar.f3007f == 2) {
                    daVar.deleteItem(ddVar);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f3061c.f3057b.mo1004a();
    }

    protected void onSessionFailed() {
        this.f3061c.f3057b.mo1005a("");
    }
}
