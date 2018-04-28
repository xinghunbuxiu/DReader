package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class dj extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3025a;
    /* renamed from: b */
    final /* synthetic */ boolean f3026b;
    /* renamed from: c */
    final /* synthetic */ ArrayList f3027c;
    /* renamed from: d */
    final /* synthetic */ de f3028d;
    /* renamed from: e */
    private final dv f3029e = new dv();

    dj(de deVar, C0657i c0657i, al alVar, boolean z, ArrayList arrayList) {
        this.f3028d = deVar;
        this.f3025a = alVar;
        this.f3026b = z;
        this.f3027c = arrayList;
        super(c0657i);
    }

    protected void onSessionTry() {
        da daVar = new da(this.f3025a);
        daVar.m4295a();
        if (this.f3026b) {
            this.f3029e.m4372a(daVar);
            Collection arrayList = new ArrayList(this.f3027c.size());
            Iterator it = this.f3027c.iterator();
            while (it.hasNext()) {
                dd ddVar = (dd) it.next();
                int i = ddVar.f3002a;
                String str = ddVar.f3003b;
                long j = ddVar.f3008g;
                if (ddVar.f3005d) {
                    arrayList.add(this.f3028d.m4311a(this.f3029e, i, str, j));
                } else {
                    arrayList = arrayList;
                    arrayList.add(this.f3028d.m4312a(this.f3029e, i, str, ddVar.f3004c, j));
                }
            }
            daVar.updateItems(arrayList);
            return;
        }
        daVar.updateItems(this.f3027c);
    }

    protected void onSessionSucceeded() {
        if (this.f3025a.m3365a(this.f3028d.f3011c) && this.f3026b) {
            this.f3028d.m4321a(this.f3029e);
        }
    }

    protected void onSessionFailed() {
    }
}
