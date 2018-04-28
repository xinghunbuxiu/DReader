package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class jy {
    /* renamed from: a */
    public final ArrayList<dd> f3431a = new ArrayList();
    /* renamed from: b */
    public final ArrayList<bt> f3432b = new ArrayList();
    /* renamed from: c */
    public final HashMap<String, dd> f3433c = new HashMap();
    /* renamed from: d */
    public final HashMap<String, bt> f3434d = new HashMap();

    /* renamed from: a */
    public void m4792a() {
        this.f3431a.addAll(de.m4313a().m4343b());
        this.f3432b.addAll(bu.m4077a().m4112b());
    }

    /* renamed from: b */
    public void m4793b() {
        Iterator it = this.f3431a.iterator();
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            this.f3433c.put(ddVar.f3003b, ddVar);
        }
        it = this.f3432b.iterator();
        while (it.hasNext()) {
            bt btVar = (bt) it.next();
            this.f3434d.put(btVar.f2858b, btVar);
        }
    }
}
