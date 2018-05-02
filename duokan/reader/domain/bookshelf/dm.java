package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class dm extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ dh d;
    private final ea e = new ea();

    dm(dh dhVar, ab abVar, boolean z, ArrayList arrayList) {
        this.d = dhVar;
        this.a = abVar;
        this.b = z;
        this.c = arrayList;
    }

    protected void onSessionTry() {
        dd ddVar = new dd(this.a);
        ddVar.a();
        if (this.b) {
            this.e.a(ddVar);
            Collection arrayList = new ArrayList(this.c.size());
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                dg dgVar = (dg) it.next();
                int i = dgVar.a;
                String str = dgVar.b;
                long j = dgVar.g;
                if (dgVar.d) {
                    arrayList.add(this.d.a(this.e, i, str, j));
                } else {
                    arrayList = arrayList;
                    arrayList.add(this.d.a(this.e, i, str, dgVar.c, j));
                }
            }
            ddVar.updateItems(arrayList);
            return;
        }
        ddVar.updateItems(this.c);
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.d.c) && this.b) {
            this.d.a(this.e);
        }
    }

    protected void onSessionFailed() {
    }
}
