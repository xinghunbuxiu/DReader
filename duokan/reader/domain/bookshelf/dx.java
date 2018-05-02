package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class dx extends al {
    final /* synthetic */ ab a;
    final /* synthetic */ List b;
    final /* synthetic */ ec c;
    final /* synthetic */ dh d;
    private b e;

    dx(dh dhVar, ab abVar, List list, ec ecVar) {
        this.d = dhVar;
        this.a = abVar;
        this.b = list;
        this.c = ecVar;
    }

    protected void onSessionTry() {
        fj fjVar = new fj(this, this.a);
        HashMap hashMap = new HashMap();
        for (dg dgVar : this.b) {
            fr frVar = (fr) hashMap.get(Integer.valueOf(dgVar.a));
            if (frVar == null) {
                frVar = new fr();
                frVar.a = dgVar.a;
                frVar.b = new ArrayList();
                hashMap.put(Integer.valueOf(dgVar.a), frVar);
            }
            frVar.b.add(dgVar);
        }
        this.e = fjVar.b(hashMap.values());
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.d.c)) {
            this.c.a("");
        } else if (this.e.b == 1) {
            i.f().a(this.a.a, new dy(this));
        } else if (this.e.b != 0) {
            this.c.a(this.e.c);
        } else {
            this.c.a();
        }
    }

    protected void onSessionFailed() {
        this.c.a(this.d.b.getResources().getString(com.duokan.b.i.general__shared__network_error));
    }
}
