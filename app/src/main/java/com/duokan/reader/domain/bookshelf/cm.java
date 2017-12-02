package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class cm extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ bv d;
    private final cs e = new cs();

    cm(bv bvVar, ab abVar, boolean z, ArrayList arrayList) {
        this.d = bvVar;
        this.a = abVar;
        this.b = z;
        this.c = arrayList;
    }

    protected void onSessionTry() {
        br brVar = new br(this.a);
        brVar.a();
        if (this.b) {
            this.e.a(brVar);
            Collection arrayList = new ArrayList(this.c.size());
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                bu buVar = (bu) it.next();
                int i = buVar.a;
                String str = buVar.b;
                if (buVar.h == 1) {
                    arrayList.add(this.d.a(this.e, i, str, buVar.c, buVar.i));
                } else if (buVar.h == 2) {
                    arrayList.add(this.d.b(this.e, i, str, buVar.c, buVar.i));
                } else if (buVar.h == 3) {
                    arrayList.add(this.d.a(this.e, i, str, buVar.i));
                }
            }
            brVar.updateItems(arrayList);
            return;
        }
        brVar.updateItems(this.c);
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.d.c) && this.b) {
            this.d.a(this.e);
        }
    }

    protected void onSessionFailed() {
    }
}
