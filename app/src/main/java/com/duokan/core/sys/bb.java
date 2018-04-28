package com.duokan.core.sys;

import java.util.HashMap;

public class bb implements C0352r {
    /* renamed from: a */
    private static final HashMap<String, bc> f689a = new HashMap();
    /* renamed from: b */
    private final bc f690b;
    /* renamed from: c */
    private boolean f691c = false;

    private bb(bc bcVar) {
        this.f690b = bcVar;
    }

    /* renamed from: e */
    public static bb m947e(String str) {
        bb bbVar;
        synchronized (f689a) {
            bc bcVar = (bc) f689a.get(str);
            if (bcVar == null) {
                bcVar = new bc(str);
            }
            bcVar.f697a++;
            f689a.put(str, bcVar);
            bbVar = new bb(bcVar);
        }
        return bbVar;
    }

    /* renamed from: a */
    public void mo417a(String str, String str2, String str3) {
        this.f690b.mo417a(str, str2, str3);
    }

    /* renamed from: a */
    public boolean mo418a(String str) {
        return this.f690b.mo418a(str);
    }

    /* renamed from: a */
    public boolean mo419a(String str, String str2) {
        return this.f690b.mo419a(str, str2);
    }

    /* renamed from: a */
    public void mo416a(String str, long j) {
        this.f690b.mo416a(str, j);
    }

    /* renamed from: b */
    public boolean mo421b(String str) {
        return this.f690b.mo421b(str);
    }

    /* renamed from: c */
    public C0353p mo422c(String str) {
        return this.f690b.m973e(str);
    }

    /* renamed from: d */
    public C0354q mo424d(String str) {
        return this.f690b.m974f(str);
    }

    /* renamed from: a */
    public void mo415a() {
        this.f690b.mo415a();
    }

    /* renamed from: b */
    public void mo420b() {
        this.f690b.mo420b();
    }

    /* renamed from: c */
    public void mo423c() {
        synchronized (f689a) {
            if (this.f691c) {
                return;
            }
            bc bcVar = this.f690b;
            int i = bcVar.f697a - 1;
            bcVar.f697a = i;
            if (i == 0) {
                this.f690b.mo423c();
                f689a.remove(this.f690b.m972d());
            }
            this.f691c = true;
        }
    }
}
