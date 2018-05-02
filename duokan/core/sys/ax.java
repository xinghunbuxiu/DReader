package com.duokan.core.sys;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

class ax {
    public String a;
    public String b = "";
    public final long c;
    public final AtomicLong d = new AtomicLong(0);
    public final AtomicLong e = new AtomicLong(0);
    public final AtomicLong f = new AtomicLong(0);
    public String g = null;
    public int h = 0;
    public String i = null;
    public ba[] j = null;
    public final LinkedList k = new LinkedList();

    public ax(String str, String str2, long j) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d.set(j);
        this.e.set(j);
    }

    public boolean a() {
        return !this.k.isEmpty();
    }
}
