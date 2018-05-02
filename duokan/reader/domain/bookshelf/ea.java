package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class ea {
    public final ArrayList a;
    public final ArrayList b;
    @SuppressLint({"UseSparseArrays"})
    public final HashMap c;
    public final HashMap d;

    private ea() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public void a(dd ddVar) {
        a(ddVar.queryItems());
    }

    public void a(Collection collection) {
        this.a.clear();
        this.c.clear();
        this.b.clear();
        this.d.clear();
        this.a.addAll(collection);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            dg dgVar = (dg) it.next();
            HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(dgVar.a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.c.put(Integer.valueOf(dgVar.a), hashMap);
            }
            hashMap.put(dgVar.b, dgVar);
            if (!dgVar.d) {
                this.b.add(dgVar);
                hashMap = (HashMap) this.d.get(Integer.valueOf(dgVar.a));
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.d.put(Integer.valueOf(dgVar.a), hashMap);
                }
                hashMap.put(dgVar.b, dgVar);
            }
        }
    }

    public void a(dg dgVar) {
        this.a.add(dgVar);
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(dgVar.a));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.c.put(Integer.valueOf(dgVar.a), hashMap);
        }
        hashMap.put(dgVar.b, dgVar);
        if (!dgVar.d) {
            this.b.add(dgVar);
            hashMap = (HashMap) this.d.get(Integer.valueOf(dgVar.a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.d.put(Integer.valueOf(dgVar.a), hashMap);
            }
            hashMap.put(dgVar.b, dgVar);
        }
    }

    public void b(dg dgVar) {
        this.a.remove(dgVar);
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(dgVar.a));
        if (hashMap != null) {
            hashMap.remove(dgVar.b);
        }
        if (!dgVar.d) {
            this.b.remove(dgVar);
            hashMap = (HashMap) this.d.get(Integer.valueOf(dgVar.a));
            if (hashMap != null) {
                hashMap.remove(dgVar.b);
            }
        }
    }

    public dg a(int i, String str) {
        HashMap hashMap = (HashMap) this.c.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (dg) hashMap.get(str);
    }

    public dg b(int i, String str) {
        HashMap hashMap = (HashMap) this.d.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (dg) hashMap.get(str);
    }
}
