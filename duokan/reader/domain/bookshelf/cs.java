package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class cs {
    public final ArrayList a;
    public final ArrayList b;
    public final HashMap c;
    public final HashMap d;

    private cs() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public void a(br brVar) {
        a(brVar.queryItems());
    }

    public void a(Collection collection) {
        this.a.clear();
        this.c.clear();
        this.b.clear();
        this.d.clear();
        this.a.addAll(collection);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            bu buVar = (bu) it.next();
            HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(buVar.a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.c.put(Integer.valueOf(buVar.a), hashMap);
            }
            hashMap.put(buVar.b, buVar);
            if (!buVar.c()) {
                this.b.add(buVar);
                hashMap = (HashMap) this.d.get(Integer.valueOf(buVar.a));
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.d.put(Integer.valueOf(buVar.a), hashMap);
                }
                hashMap.put(buVar.b, buVar);
            }
        }
    }

    public void a(bu buVar) {
        this.a.add(buVar);
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(buVar.a));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.c.put(Integer.valueOf(buVar.a), hashMap);
        }
        hashMap.put(buVar.b, buVar);
        if (!buVar.c()) {
            this.b.add(buVar);
            hashMap = (HashMap) this.d.get(Integer.valueOf(buVar.a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.d.put(Integer.valueOf(buVar.a), hashMap);
            }
            hashMap.put(buVar.b, buVar);
        }
    }

    public void b(bu buVar) {
        this.a.remove(buVar);
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(buVar.a));
        if (hashMap != null) {
            hashMap.remove(buVar.b);
        }
        if (!buVar.c()) {
            this.b.remove(buVar);
            hashMap = (HashMap) this.d.get(Integer.valueOf(buVar.a));
            if (hashMap != null) {
                hashMap.remove(buVar.b);
            }
        }
    }

    public bu a(int i, String str) {
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (bu) hashMap.get(str);
    }
}
