package com.duokan.reader.domain.account;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.domain.account.l */
class C0710l implements C0706e {
    /* renamed from: a */
    final /* synthetic */ C0709k f2487a;

    C0710l(C0709k c0709k) {
        this.f2487a = c0709k;
    }

    /* renamed from: a */
    public void mo878a(C0672a c0672a) {
        WebLog.init().w(UThread.isCurrentThread());
        synchronized (this.f2487a) {
            this.f2487a.f2484k.put(c0672a.getClass(), c0672a);
        }
    }

    /* renamed from: b */
    public void mo880b(C0672a c0672a) {
        WebLog.init().w(UThread.isCurrentThread());
        this.f2487a.m3487d(c0672a);
    }

    /* renamed from: c */
    public void mo881c(C0672a c0672a) {
        this.f2487a.m3489e(c0672a);
    }

    /* renamed from: a */
    public C0285n mo875a() {
        return this.f2487a.f2478e;
    }

    /* renamed from: b */
    public C0285n mo879b() {
        return this.f2487a.f2479f;
    }

    /* renamed from: a */
    public String mo877a(int i) {
        return this.f2487a.f2476c.getString(i);
    }

    /* renamed from: a */
    public <T extends C0672a> T mo876a(Class<T> cls) {
        return this.f2487a.m3502b((Class) cls);
    }
}
