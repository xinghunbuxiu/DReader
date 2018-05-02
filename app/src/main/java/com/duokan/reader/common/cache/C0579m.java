package com.duokan.reader.common.cache;

/* renamed from: com.duokan.reader.common.cache.m */
public class C0579m extends ag {
    /* renamed from: a */
    private static Object f1887a = new Object();
    /* renamed from: b */
    private static C0579m f1888b = null;

    private C0579m() {
        super(C0578l.m2590a());
    }

    /* renamed from: a */
    public static C0579m m2592a() {
        if (f1888b == null) {
            synchronized (f1887a) {
                if (f1888b == null) {
                    f1888b = new C0579m();
                }
            }
        }
        return f1888b;
    }
}
