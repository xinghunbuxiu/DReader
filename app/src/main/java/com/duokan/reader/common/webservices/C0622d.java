package com.duokan.reader.common.webservices;

import java.util.concurrent.Callable;

/* renamed from: com.duokan.reader.common.webservices.d */
class C0622d implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ Object f2059a;
    /* renamed from: b */
    final /* synthetic */ WebSession f2060b;

    C0622d(WebSession webSession, Object obj) {
        this.f2060b = webSession;
        this.f2059a = obj;
    }

    public /* synthetic */ Object call() {
        return m2816a();
    }

    /* renamed from: a */
    public Void m2816a() {
        this.f2060b.onSessionProgressUpdate(this.f2059a);
        return null;
    }
}
