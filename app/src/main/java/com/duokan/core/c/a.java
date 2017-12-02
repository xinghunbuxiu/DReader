package com.duokan.core.c;

import java.util.Iterator;

public class a {
    public static Object a(Iterable iterable, b bVar) {
        if (iterable == null || bVar == null) {
            return null;
        }
        for (Object next : iterable) {
            if (bVar.a(next)) {
                return next;
            }
        }
        return null;
    }

    public static Object b(Iterable iterable, b bVar) {
        if (iterable == null || bVar == null) {
            return null;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (bVar.a(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }
}
