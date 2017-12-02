package com.duokan.core.sys;

import java.util.HashMap;

public class bb implements r {
    private static final HashMap a = new HashMap();
    private final bc b;
    private boolean c = false;

    private bb(bc bcVar) {
        this.b = bcVar;
    }

    public static bb e(String str) {
        bb bbVar;
        synchronized (a) {
            bc bcVar = (bc) a.get(str);
            if (bcVar == null) {
                bcVar = new bc(str);
            }
            bcVar.a++;
            a.put(str, bcVar);
            bbVar = new bb(bcVar);
        }
        return bbVar;
    }

    public void a(String str, String str2, String str3) {
        this.b.a(str, str2, str3);
    }

    public boolean a(String str) {
        return this.b.a(str);
    }

    public boolean a(String str, String str2) {
        return this.b.a(str, str2);
    }

    public void a(String str, long j) {
        this.b.a(str, j);
    }

    public boolean b(String str) {
        return this.b.b(str);
    }

    public p c(String str) {
        return this.b.e(str);
    }

    public q d(String str) {
        return this.b.f(str);
    }

    public void a() {
        this.b.a();
    }

    public void b() {
        this.b.b();
    }

    public void c() {
        synchronized (a) {
            if (this.c) {
                return;
            }
            bc bcVar = this.b;
            int i = bcVar.a - 1;
            bcVar.a = i;
            if (i == 0) {
                this.b.c();
                a.remove(this.b.d());
            }
            this.c = true;
        }
    }
}
