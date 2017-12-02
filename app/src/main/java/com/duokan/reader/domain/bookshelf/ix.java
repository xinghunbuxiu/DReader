package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ix extends ap {
    protected final ab b;
    protected final jl c = new jl();
    protected final jm d;
    protected final List e;
    protected final ArrayList f;
    protected final iq g;
    final /* synthetic */ hi h;

    public ix(hi hiVar, ab abVar, List list, iq iqVar) {
        this.h = hiVar;
        this.b = abVar;
        this.c.a();
        this.d = new jm();
        this.d.a();
        this.e = list;
        this.f = new ArrayList();
        this.g = iqVar;
    }

    protected void onSessionTry() {
        this.c.b();
        this.d.b();
        this.h.u();
        this.h.a(this.c);
        HashMap v = this.h.v();
        try {
            this.h.k.a();
            this.h.g.b();
            for (dg dgVar : this.e) {
                c cVar = (c) v.get(dgVar.b);
                if (cVar != null) {
                    if (dgVar.d) {
                        cVar.d(-1);
                        cVar.aL();
                    } else if (cVar.ax() < dgVar.c) {
                        cVar.d(dgVar.c);
                        cVar.aL();
                    }
                }
            }
            for (c cVar2 : v.values()) {
                if (this.c.a(cVar2)) {
                    dg dgVar2 = (dg) this.d.c.get(cVar2.ap());
                    if (dgVar2 == null) {
                        if (cVar2.ax() > 0) {
                            this.f.add(cVar2);
                        }
                    } else if (cVar2.ax() > dgVar2.c) {
                        this.f.add(cVar2);
                    }
                }
            }
            this.h.g.f();
            this.h.g.c();
            this.h.k.b();
        } catch (Throwable th) {
            this.h.k.b();
        }
    }

    protected void onSessionSucceeded() {
        if (!this.b.a(this.h.j)) {
            return;
        }
        if (this.g == null || !this.g.isCancelled()) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                dh.a().a(cVar.ao(), cVar.ap(), cVar.ax());
            }
        }
    }

    protected void onSessionFailed() {
    }
}
