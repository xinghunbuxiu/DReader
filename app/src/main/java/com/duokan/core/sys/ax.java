package com.duokan.core.sys;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

class ax {
    /* renamed from: a */
    public String f670a;
    /* renamed from: b */
    public String f671b = "";
    /* renamed from: c */
    public final long f672c;
    /* renamed from: d */
    public final AtomicLong f673d = new AtomicLong(0);
    /* renamed from: e */
    public final AtomicLong f674e = new AtomicLong(0);
    /* renamed from: f */
    public final AtomicLong f675f = new AtomicLong(0);
    /* renamed from: g */
    public String f676g = null;
    /* renamed from: h */
    public int f677h = 0;
    /* renamed from: i */
    public String f678i = null;
    /* renamed from: j */
    public ba[] f679j = null;
    /* renamed from: k */
    public final LinkedList<at> f680k = new LinkedList();

    public ax(String str, String str2, long j) {
        this.f670a = str;
        this.f671b = str2;
        this.f672c = j;
        this.f673d.set(j);
        this.f674e.set(j);
    }

    /* renamed from: a */
    public boolean m927a() {
        return !this.f680k.isEmpty();
    }
}
