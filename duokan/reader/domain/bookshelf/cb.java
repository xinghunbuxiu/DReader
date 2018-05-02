package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class cb extends ap {
    final /* synthetic */ jl a;
    final /* synthetic */ ab b;
    final /* synthetic */ boolean c;
    final /* synthetic */ da d;
    final /* synthetic */ bv e;
    private bt f;
    private cs g = new cs();

    cb(bv bvVar, jl jlVar, ab abVar, boolean z, da daVar) {
        this.e = bvVar;
        this.a = jlVar;
        this.b = abVar;
        this.c = z;
        this.d = daVar;
    }

    protected void onSessionTry() {
        this.a.b();
        br brVar = new br(this.b);
        brVar.a();
        this.f = brVar.b();
        if (this.c) {
            this.g.a(brVar);
        }
    }

    protected void onSessionSucceeded() {
        if (this.b.a(this.e.c)) {
            if (this.c) {
                this.e.a(this.g);
            }
            List arrayList = new ArrayList();
            Iterator it = this.e.d.a.iterator();
            while (it.hasNext()) {
                bu buVar = (bu) it.next();
                if (buVar.g && this.a.a(buVar.a, buVar.b)) {
                    arrayList.add(buVar.a());
                }
            }
            if (arrayList.size() > 0) {
                this.e.a(this.f, arrayList, new cc(this));
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
