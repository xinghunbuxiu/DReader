package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ir extends WebSession {
    /* renamed from: b */
    protected final al f2817b;
    /* renamed from: c */
    protected final jx f2818c = new jx();
    /* renamed from: d */
    protected final jy f2819d;
    /* renamed from: e */
    protected final List<dd> f2820e;
    /* renamed from: f */
    protected final ArrayList<C0800c> f2821f;
    /* renamed from: g */
    protected final ik f2822g;
    /* renamed from: h */
    final /* synthetic */ hc f2823h;

    public ir(hc hcVar, al alVar, List<dd> list, ik ikVar) {
        this.f2823h = hcVar;
        super(aq.f2771a);
        this.f2817b = alVar;
        this.f2818c.m4783a();
        this.f2819d = new jy();
        this.f2819d.m4792a();
        this.f2820e = list;
        this.f2821f = new ArrayList();
        this.f2822g = ikVar;
    }

    protected void onSessionTry() {
        this.f2818c.m4787b();
        this.f2819d.m4793b();
        this.f2823h.m3946u();
        this.f2823h.m3891a(this.f2818c);
        HashMap v = this.f2823h.m3947v();
        try {
            this.f2823h.f2747k.mo1090a();
            this.f2823h.f2743g.m677b();
            for (dd ddVar : this.f2820e) {
                C0800c c0800c = (C0800c) v.get(ddVar.f3003b);
                if (c0800c != null) {
                    if (ddVar.f3005d) {
                        c0800c.m4220d(-1);
                        c0800c.aN();
                    } else if (c0800c.az() < ddVar.f3004c) {
                        c0800c.m4220d(ddVar.f3004c);
                        c0800c.aN();
                    }
                }
            }
            for (C0800c c0800c2 : v.values()) {
                if (this.f2818c.m4785a(c0800c2)) {
                    dd ddVar2 = (dd) this.f2819d.f3433c.get(c0800c2.ar());
                    if (ddVar2 == null) {
                        if (c0800c2.az() > 0) {
                            this.f2821f.add(c0800c2);
                        }
                    } else if (c0800c2.az() > ddVar2.f3004c) {
                        this.f2821f.add(c0800c2);
                    }
                }
            }
            this.f2823h.f2743g.m681f();
            this.f2823h.f2743g.m678c();
            this.f2823h.f2747k.mo1096b();
        } catch (Throwable th) {
            this.f2823h.f2747k.mo1096b();
        }
    }

    protected void onSessionSucceeded() {
        if (!this.f2817b.m3365a(this.f2823h.f2746j)) {
            return;
        }
        if (this.f2822g == null || !this.f2822g.isCancelled()) {
            Iterator it = this.f2821f.iterator();
            while (it.hasNext()) {
                C0800c c0800c = (C0800c) it.next();
                de.m4313a().m4339a(c0800c.aq(), c0800c.ar(), c0800c.az());
            }
        }
    }

    protected void onSessionFailed() {
    }
}
