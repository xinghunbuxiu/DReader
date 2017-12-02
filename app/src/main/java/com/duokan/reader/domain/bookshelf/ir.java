package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;

public class ir extends ap {
    private final ab a;
    private final jl b = new jl();
    final /* synthetic */ hi c;
    private final jm d;
    private final ArrayList e;

    public ir(hi hiVar, ab abVar) {
        this.c = hiVar;
        this.a = abVar;
        this.b.a();
        this.d = new jm();
        this.d.a();
        this.e = new ArrayList();
    }

    protected void onSessionTry() {
        this.b.b();
        this.d.b();
        this.c.u();
        this.c.a(this.b);
        for (an anVar : this.c.v().values()) {
            if (this.b.a((c) anVar) && this.b.b((c) anVar)) {
                bu buVar = (bu) this.d.d.get(anVar.ap());
                if (buVar == null) {
                    this.e.add(ct.a(anVar.ao(), anVar.ap(), this.c.a(anVar).k()));
                } else {
                    aa b = this.c.b(anVar.aH());
                    if (!b.k().equals(buVar.c)) {
                        this.e.add(ct.a(anVar.ao(), anVar.ap(), buVar.c, b.k()));
                    }
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.a(this.c.j)) {
            bv.a().a(this.e);
        }
    }

    protected void onSessionFailed() {
    }
}
