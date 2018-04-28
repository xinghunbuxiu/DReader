package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bz extends WebSession {
    /* renamed from: a */
    final /* synthetic */ jx f2885a;
    /* renamed from: b */
    final /* synthetic */ al f2886b;
    /* renamed from: c */
    final /* synthetic */ boolean f2887c;
    /* renamed from: d */
    final /* synthetic */ cx f2888d;
    /* renamed from: e */
    final /* synthetic */ bu f2889e;
    /* renamed from: f */
    private bs f2890f;
    /* renamed from: g */
    private cp f2891g = new cp();

    bz(bu buVar, C0657i c0657i, jx jxVar, al alVar, boolean z, cx cxVar) {
        this.f2889e = buVar;
        this.f2885a = jxVar;
        this.f2886b = alVar;
        this.f2887c = z;
        this.f2888d = cxVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f2885a.m4787b();
        bq bqVar = new bq(this.f2886b);
        bqVar.m4053a();
        this.f2890f = bqVar.m4054b();
        if (this.f2887c) {
            this.f2891g.m4278a(bqVar);
        }
    }

    protected void onSessionSucceeded() {
        if (this.f2886b.m3365a(this.f2889e.f2868c)) {
            if (this.f2887c) {
                this.f2889e.m4088a(this.f2891g);
            }
            List arrayList = new ArrayList();
            Iterator it = this.f2889e.f2869d.f2980a.iterator();
            while (it.hasNext()) {
                bt btVar = (bt) it.next();
                if (btVar.f2863g && this.f2885a.m4784a(btVar.f2857a, btVar.f2858b)) {
                    arrayList.add(btVar.m4068a());
                }
            }
            if (arrayList.size() > 0) {
                this.f2889e.m4082a(this.f2890f, arrayList, new ca(this));
                return;
            }
            this.f2888d.mo976a();
            m4118a();
            return;
        }
        this.f2888d.mo977a("");
        m4118a();
    }

    protected void onSessionFailed() {
        this.f2888d.mo977a("");
        m4118a();
    }

    /* renamed from: a */
    private void m4118a() {
        this.f2889e.f2873h.poll();
        this.f2889e.m4100e();
    }
}
