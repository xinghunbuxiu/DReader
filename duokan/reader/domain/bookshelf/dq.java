package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class dq extends ap {
    final /* synthetic */ List a;
    final /* synthetic */ ab b;
    final /* synthetic */ dp c;
    private final ea d = new ea();
    private final ea e = new ea();
    private ArrayList f = new ArrayList();

    dq(dp dpVar, List list, ab abVar) {
        this.c = dpVar;
        this.a = list;
        this.b = abVar;
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (!this.c.b.e) {
            this.c.b.e = true;
            this.c.b.f = System.currentTimeMillis();
        }
    }

    protected void onSessionTry() {
        this.d.a(this.a);
        dd ddVar = new dd(this.b);
        ddVar.a();
        df b = ddVar.b();
        this.e.a(ddVar);
        Collection arrayList = new ArrayList();
        Iterator it = this.d.a.iterator();
        while (it.hasNext()) {
            dg dgVar = (dg) it.next();
            dg a = this.e.a(dgVar.a, dgVar.b);
            if (a == null) {
                this.e.a(dgVar);
                arrayList.add(dgVar);
            } else if (a.d) {
                if (a.g < dgVar.c) {
                    this.e.b(a);
                    this.e.a(dgVar);
                    arrayList.add(dgVar);
                }
            } else if (a.c < dgVar.c) {
                this.e.b(a);
                this.e.a(dgVar);
                arrayList.add(dgVar);
            }
        }
        ddVar.updateItems(arrayList);
        this.f.addAll(arrayList);
        Iterator it2 = this.d.a.iterator();
        long j = 0;
        while (it2.hasNext()) {
            long j2;
            dgVar = (dg) it2.next();
            if (j == 0) {
                j2 = dgVar.c;
            } else if (j > dgVar.c) {
                j2 = dgVar.c;
            } else {
                j2 = j;
            }
            j = j2;
        }
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        arrayList = new ArrayList();
        Iterator it3 = this.e.a.iterator();
        while (it3.hasNext()) {
            dgVar = (dg) it3.next();
            if (!dgVar.d && dgVar.c >= r2 && this.d.a(dgVar.a, dgVar.b) == null) {
                arrayList.add(dgVar);
            }
        }
        if (!arrayList.isEmpty()) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                this.e.b((dg) it.next());
            }
            ddVar.deleteItems(arrayList);
        }
        this.f.addAll(arrayList);
        b.b = System.currentTimeMillis();
        ddVar.updateInfo(b);
    }

    protected void onSessionSucceeded() {
        if (this.b.a(this.c.b.c)) {
            this.c.b.a(this.e);
            this.c.a.a(this.f);
            return;
        }
        this.c.a.a("");
    }

    protected void onSessionFailed() {
        this.c.a.a("");
    }
}
