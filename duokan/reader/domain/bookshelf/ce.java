package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Iterator;

class ce extends ap {
    final /* synthetic */ ab a;
    final /* synthetic */ bt b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ cd d;

    ce(cd cdVar, ab abVar, bt btVar, ArrayList arrayList) {
        this.d = cdVar;
        this.a = abVar;
        this.b = btVar;
        this.c = arrayList;
    }

    protected void onSessionTry() {
        br brVar = new br(this.a);
        brVar.a();
        brVar.updateInfo(this.b);
        if (!this.c.isEmpty()) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                bu buVar = (bu) it.next();
                if (buVar.h == 0) {
                    brVar.updateItem(buVar);
                } else if (buVar.h == 3) {
                    brVar.deleteItem(buVar);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.d.c.c)) {
            this.d.b.a();
        } else {
            this.d.b.a("");
        }
    }

    protected void onSessionFailed() {
        this.d.b.a("");
    }
}
