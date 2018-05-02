package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class dt extends ap {
    final /* synthetic */ jl a;
    final /* synthetic */ ab b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ee d;
    final /* synthetic */ dh e;
    private ea f = new ea();

    dt(dh dhVar, jl jlVar, ab abVar, boolean z, ee eeVar) {
        this.e = dhVar;
        this.a = jlVar;
        this.b = abVar;
        this.c = z;
        this.d = eeVar;
    }

    protected void onSessionTry() {
        this.a.b();
        dd ddVar = new dd(this.b);
        ddVar.a();
        if (this.c) {
            this.f.a(ddVar);
        }
    }

    protected void onSessionSucceeded() {
        if (this.b.a(this.e.c)) {
            if (this.c) {
                this.e.a(this.f);
            }
            List arrayList = new ArrayList();
            Iterator it = this.e.d.a.iterator();
            while (it.hasNext()) {
                dg dgVar = (dg) it.next();
                if (dgVar.e && this.a.a(dgVar.a, dgVar.b)) {
                    arrayList.add(dgVar.a());
                }
            }
            if (arrayList.size() > 0) {
                this.e.a(arrayList, new du(this));
                return;
            }
            this.d.a();
            a();
            return;
        }
        this.d.a("");
        a();
    }

    protected void onSessionFailed() {
        this.d.a("");
        a();
    }

    private void a() {
        this.e.h.poll();
        this.e.e();
    }
}
