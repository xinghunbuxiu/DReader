package com.duokan.reader.common.cache;

public class e extends ag {
    private static Object a = new Object();
    private static e b = null;

    private e() {
        super(f.a());
    }

    public static e a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }
}
