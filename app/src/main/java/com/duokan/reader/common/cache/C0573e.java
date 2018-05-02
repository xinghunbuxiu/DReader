package com.duokan.reader.common.cache;

/* renamed from: com.duokan.reader.common.cache.e */
public class C0573e extends ag {
    /* renamed from: a */
    private static Object f1881a = new Object();
    /* renamed from: b */
    private static C0573e f1882b = null;

    private C0573e() {
        super(C0574f.m2573a());
    }

    /* renamed from: a */
    public static C0573e m2572a() {
        if (f1882b == null) {
            synchronized (f1881a) {
                if (f1882b == null) {
                    f1882b = new C0573e();
                }
            }
        }
        return f1882b;
    }
}
