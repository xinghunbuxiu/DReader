package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class dp extends WebSession {
    /* renamed from: a */
    final /* synthetic */ jx f3049a;
    /* renamed from: b */
    final /* synthetic */ al f3050b;
    /* renamed from: c */
    final /* synthetic */ boolean f3051c;
    /* renamed from: d */
    final /* synthetic */ dz f3052d;
    /* renamed from: e */
    final /* synthetic */ de f3053e;
    /* renamed from: f */
    private dv f3054f = new dv();

    dp(de deVar, C0657i c0657i, jx jxVar, al alVar, boolean z, dz dzVar) {
        this.f3053e = deVar;
        this.f3049a = jxVar;
        this.f3050b = alVar;
        this.f3051c = z;
        this.f3052d = dzVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f3049a.m4787b();
        da daVar = new da(this.f3050b);
        daVar.m4295a();
        if (this.f3051c) {
            this.f3054f.m4372a(daVar);
        }
    }

    protected void onSessionSucceeded() {
        if (this.f3050b.m3365a(this.f3053e.f3011c)) {
            if (this.f3051c) {
                this.f3053e.m4321a(this.f3054f);
            }
            List arrayList = new ArrayList();
            Iterator it = this.f3053e.f3012d.f3067a.iterator();
            while (it.hasNext()) {
                dd ddVar = (dd) it.next();
                if (ddVar.f3006e && this.f3049a.m4784a(ddVar.f3002a, ddVar.f3003b)) {
                    arrayList.add(ddVar.m4305a());
                }
            }
            if (arrayList.size() > 0) {
                this.f3053e.m4324a(arrayList, new dq(this));
                return;
            }
            this.f3052d.mo1004a();
            m4356a();
            return;
        }
        this.f3052d.mo1005a("");
        m4356a();
    }

    protected void onSessionFailed() {
        this.f3052d.mo1005a("");
        m4356a();
    }

    /* renamed from: a */
    private void m4356a() {
        this.f3053e.f3016h.poll();
        this.f3053e.m4333e();
    }
}
