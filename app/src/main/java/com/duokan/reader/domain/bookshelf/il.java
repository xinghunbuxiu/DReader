package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;

public class il extends WebSession {
    /* renamed from: a */
    private final al f2779a;
    /* renamed from: b */
    private final jx f2780b = new jx();
    /* renamed from: c */
    final /* synthetic */ hc f2781c;
    /* renamed from: d */
    private final jy f2782d;
    /* renamed from: e */
    private final ArrayList<cq> f2783e;

    public il(hc hcVar, al alVar) {
        this.f2781c = hcVar;
        super(aq.f2771a);
        this.f2779a = alVar;
        this.f2780b.m4783a();
        this.f2782d = new jy();
        this.f2782d.m4792a();
        this.f2783e = new ArrayList();
    }

    protected void onSessionTry() {
        this.f2780b.m4787b();
        this.f2782d.m4793b();
        this.f2781c.m3946u();
        this.f2781c.m3891a(this.f2780b);
        for (an anVar : this.f2781c.m3947v().values()) {
            if (this.f2780b.m4785a((C0800c) anVar) && this.f2780b.m4789b((C0800c) anVar)) {
                bt btVar = (bt) this.f2782d.f3434d.get(anVar.ar());
                if (btVar == null) {
                    this.f2783e.add(cq.m4283a(anVar.aq(), anVar.ar(), this.f2781c.m3862a(anVar).m3770k()));
                } else {
                    aa b = this.f2781c.m3904b(anVar.aJ());
                    if (!b.m3770k().equals(btVar.f2859c)) {
                        this.f2783e.add(cq.m4284a(anVar.aq(), anVar.ar(), btVar.f2859c, b.m3770k()));
                    }
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.f2779a.m3365a(this.f2781c.f2746j)) {
            bu.m4077a().m4110a(this.f2783e);
        }
    }

    protected void onSessionFailed() {
    }
}
