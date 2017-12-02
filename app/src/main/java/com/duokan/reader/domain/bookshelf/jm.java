package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class jm {
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();

    public void a() {
        this.a.addAll(dh.a().b());
        this.b.addAll(bv.a().b());
    }

    public void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            dg dgVar = (dg) it.next();
            this.c.put(dgVar.b, dgVar);
        }
        it = this.b.iterator();
        while (it.hasNext()) {
            bu buVar = (bu) it.next();
            this.d.put(buVar.b, buVar);
        }
    }
}
