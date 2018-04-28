package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class dn extends WebSession {
    /* renamed from: a */
    final /* synthetic */ List f3037a;
    /* renamed from: b */
    final /* synthetic */ al f3038b;
    /* renamed from: c */
    final /* synthetic */ dm f3039c;
    /* renamed from: d */
    private final dv f3040d = new dv();
    /* renamed from: e */
    private final dv f3041e = new dv();
    /* renamed from: f */
    private ArrayList<dd> f3042f = new ArrayList();

    dn(dm dmVar, C0657i c0657i, List list, al alVar) {
        this.f3039c = dmVar;
        this.f3037a = list;
        this.f3038b = alVar;
        super(c0657i);
    }

    protected void onSessionOpen() {
        super.onSessionOpen();
        if (!this.f3039c.f3036b.f3013e) {
            this.f3039c.f3036b.f3013e = true;
            this.f3039c.f3036b.f3014f = System.currentTimeMillis();
        }
    }

    protected void onSessionTry() {
        this.f3040d.m4374a(this.f3037a);
        da daVar = new da(this.f3038b);
        daVar.m4295a();
        dc b = daVar.m4296b();
        this.f3041e.m4372a(daVar);
        Collection arrayList = new ArrayList();
        Iterator it = this.f3040d.f3067a.iterator();
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            dd a = this.f3041e.m4371a(ddVar.f3002a, ddVar.f3003b);
            if (a == null) {
                this.f3041e.m4373a(ddVar);
                arrayList.add(ddVar);
            } else if (a.f3005d) {
                if (a.f3008g < ddVar.f3004c) {
                    this.f3041e.m4376b(a);
                    this.f3041e.m4373a(ddVar);
                    arrayList.add(ddVar);
                }
            } else if (a.f3004c < ddVar.f3004c) {
                this.f3041e.m4376b(a);
                this.f3041e.m4373a(ddVar);
                arrayList.add(ddVar);
            }
        }
        daVar.updateItems(arrayList);
        this.f3042f.addAll(arrayList);
        Iterator it2 = this.f3040d.f3067a.iterator();
        long j = 0;
        while (it2.hasNext()) {
            long j2;
            ddVar = (dd) it2.next();
            if (j == 0) {
                j2 = ddVar.f3004c;
            } else if (j > ddVar.f3004c) {
                j2 = ddVar.f3004c;
            } else {
                j2 = j;
            }
            j = j2;
        }
        if (j == 0) {
            j = Long.MAX_VALUE;
        }
        arrayList = new ArrayList();
        Iterator it3 = this.f3041e.f3067a.iterator();
        while (it3.hasNext()) {
            ddVar = (dd) it3.next();
            if (!ddVar.f3005d && ddVar.f3004c >= r2 && this.f3040d.m4371a(ddVar.f3002a, ddVar.f3003b) == null) {
                arrayList.add(ddVar);
            }
        }
        if (!arrayList.isEmpty()) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                this.f3041e.m4376b((dd) it.next());
            }
            daVar.deleteItems(arrayList);
        }
        this.f3042f.addAll(arrayList);
        b.f3001b = System.currentTimeMillis();
        daVar.updateInfo(b);
    }

    protected void onSessionSucceeded() {
        if (this.f3038b.m3365a(this.f3039c.f3036b.f3011c)) {
            this.f3039c.f3036b.m4321a(this.f3041e);
            this.f3039c.f3035a.mo983a(this.f3042f);
            return;
        }
        this.f3039c.f3035a.mo982a("");
    }

    protected void onSessionFailed() {
        this.f3039c.f3035a.mo982a("");
    }
}
