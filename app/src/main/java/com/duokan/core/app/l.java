package com.duokan.core.app;

import java.util.Iterator;
import java.util.LinkedList;

class l {
    private final LinkedList a = new LinkedList();

    public final synchronized k a(Class cls) {
        k kVar;
        if (cls == null) {
            kVar = null;
        } else {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (cls.isAssignableFrom(kVar.getClass())) {
                    kVar = (k) cls.cast(kVar);
                    break;
                }
            }
            kVar = null;
        }
        return kVar;
    }

    public final synchronized boolean a(k kVar) {
        boolean z;
        if (kVar == null) {
            z = false;
        } else {
            this.a.remove(kVar);
            this.a.addFirst(kVar);
            z = true;
        }
        return z;
    }

    public final synchronized boolean b(k kVar) {
        boolean z;
        if (kVar == null) {
            z = true;
        } else {
            z = this.a.remove(kVar);
        }
        return z;
    }

    public final synchronized void a() {
        this.a.clear();
    }
}
