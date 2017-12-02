package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class bz extends al {
    final /* synthetic */ ab a;
    final /* synthetic */ bt b;
    final /* synthetic */ cy c;
    final /* synthetic */ bv d;
    private b e;
    private bt f;
    private ArrayList g;

    bz(bv bvVar, ab abVar, bt btVar, cy cyVar) {
        this.d = bvVar;
        this.a = abVar;
        this.b = btVar;
        this.c = cyVar;
    }

    protected void onSessionTry() {
        fj fjVar = new fj(this, this.a);
        List arrayList = new ArrayList(af.a.length);
        for (int i : af.a) {
            fo foVar = new fo();
            foVar.a = i;
            foVar.b = this.b.a(i);
            arrayList.add(foVar);
        }
        this.e = fjVar.a(arrayList);
        if (this.e.b == 0) {
            this.f = new bt();
            this.g = new ArrayList();
            this.f.a = this.a.a;
            for (fs fsVar : ((HashMap) this.e.a).values()) {
                this.f.b(fsVar.a, fsVar.d);
                long a = this.b.a(fsVar.a);
                for (bu buVar : fsVar.b) {
                    if (buVar.d > a) {
                        a = buVar.d;
                    }
                }
                this.f.a(fsVar.a, a);
                this.g.addAll(fsVar.b);
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(this.d.c)) {
            this.c.a("");
        } else if (this.e.b == 1) {
            i.f().a(this.a.a, new ca(this));
        } else if (this.e.b != 0) {
            this.c.a(this.e.c);
        } else {
            this.c.a(this.f, this.g);
        }
    }

    protected void onSessionFailed() {
        this.c.a(this.d.b.getResources().getString(com.duokan.b.i.general__shared__network_error));
    }
}
