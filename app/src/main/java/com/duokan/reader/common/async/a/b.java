package com.duokan.reader.common.async.a;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class b implements a {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public boolean a() {
        return this.a.isEmpty();
    }

    public void a(a aVar) {
        this.a.add(aVar);
    }

    public void b() {
        this.a.clear();
    }

    public void a(Object obj) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(obj);
        }
    }

    public void a(int i, String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, str);
        }
    }
}
