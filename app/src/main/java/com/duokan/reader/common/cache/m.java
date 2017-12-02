package com.duokan.reader.common.cache;

public class m extends ag {
    private static Object a = new Object();
    private static m b = null;

    private m() {
        super(l.a());
    }

    public static m a() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new m();
                }
            }
        }
        return b;
    }
}
