package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Iterator;

class cc extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f2934a;
    /* renamed from: b */
    final /* synthetic */ bs f2935b;
    /* renamed from: c */
    final /* synthetic */ ArrayList f2936c;
    /* renamed from: d */
    final /* synthetic */ cb f2937d;

    cc(cb cbVar, C0657i c0657i, al alVar, bs bsVar, ArrayList arrayList) {
        this.f2937d = cbVar;
        this.f2934a = alVar;
        this.f2935b = bsVar;
        this.f2936c = arrayList;
        super(c0657i);
    }

    protected void onSessionTry() {
        bq bqVar = new bq(this.f2934a);
        bqVar.m4053a();
        bqVar.updateInfo(this.f2935b);
        if (!this.f2936c.isEmpty()) {
            Iterator it = this.f2936c.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                if (btVar.f2864h == 0) {
                    bqVar.updateItem(btVar);
                } else if (btVar.f2864h == 3) {
                    bqVar.deleteItem(btVar);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.f2934a.m3365a(this.f2937d.f2933c.f2868c)) {
            this.f2937d.f2932b.mo976a();
        } else {
            this.f2937d.f2932b.mo977a("");
        }
    }

    protected void onSessionFailed() {
        this.f2937d.f2932b.mo977a("");
    }
}
