package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Iterator;

class dw extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ dv c;

    dw(dv dvVar, ab abVar, ArrayList arrayList) {
        this.c = dvVar;
        this.a = abVar;
        this.b = arrayList;
    }

    protected void onSessionTry() {
        dd ddVar = new dd(this.a);
        ddVar.a();
        if (!this.b.isEmpty()) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                dg dgVar = (dg) it.next();
                if (dgVar.f == 0) {
                    ddVar.updateItem(dgVar);
                } else if (dgVar.f == 2) {
                    ddVar.deleteItem(dgVar);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        this.c.b.a();
    }

    protected void onSessionFailed() {
        this.c.b.a("");
    }
}
