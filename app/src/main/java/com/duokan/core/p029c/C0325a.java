package com.duokan.core.p029c;

import java.util.Iterator;

/* renamed from: com.duokan.core.c.a */
public class C0325a {
    /* renamed from: a */
    public static <T> T m738a(Iterable<T> iterable, C0326b<T> c0326b) {
        if (iterable == null || c0326b == null) {
            return null;
        }
        for (T next : iterable) {
            if (c0326b.mo411a(next)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static <T> T m739b(Iterable<T> iterable, C0326b<T> c0326b) {
        if (iterable == null || c0326b == null) {
            return null;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (c0326b.mo411a(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }
}
