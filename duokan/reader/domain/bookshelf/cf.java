package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class cf extends al {
    final /* synthetic */ ab a;
    final /* synthetic */ List b;
    final /* synthetic */ bt c;
    final /* synthetic */ db d;
    final /* synthetic */ bv e;
    private b f;

    cf(bv bvVar, ab abVar, List list, bt btVar, db dbVar) {
        this.e = bvVar;
        this.a = abVar;
        this.b = list;
        this.c = btVar;
        this.d = dbVar;
    }

    protected void onSessionTry() {
        fj fjVar = new fj(this, this.a);
        HashMap hashMap = new HashMap();
        for (bu buVar : this.b) {
            fp fpVar = (fp) hashMap.get(Integer.valueOf(buVar.a));
            if (fpVar == null) {
                fpVar = new fp();
                fpVar.a = buVar.a;
                fpVar.b = this.c.b(buVar.a);
                fpVar.c = new ArrayList();
                hashMap.put(Integer.valueOf(buVar.a), fpVar);
            }
            fpVar.c.add(buVar);
        }
        this.f = fjVar.a(hashMap.values());
        if (this.f.b == 0) {
            for (ft ftVar : ((HashMap) this.f.a).values()) {
                this.c.b(ftVar.a, ftVar.b);
                this.c.a(ftVar.a, ftVar.c);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.e.c)) {
            this.d.a("");
        } else if (this.f.b == 1) {
            i.f().a(this.a.a, new cg(this));
        } else if (this.f.b == 209) {
            this.d.a();
        } else if (this.f.b != 0) {
            this.d.a(this.f.c);
        } else {
            this.d.a(this.c);
        }
    }

    protected void onSessionFailed() {
        this.d.a(this.e.b.getResources().getString(com.duokan.b.i.general__shared__network_error));
    }
}
