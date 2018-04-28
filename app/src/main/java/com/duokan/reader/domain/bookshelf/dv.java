package com.duokan.reader.domain.bookshelf;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class dv {
    /* renamed from: a */
    public final ArrayList<dd> f3067a;
    /* renamed from: b */
    public final ArrayList<dd> f3068b;
    @SuppressLint({"UseSparseArrays"})
    /* renamed from: c */
    public final HashMap<Integer, HashMap<String, dd>> f3069c;
    /* renamed from: d */
    public final HashMap<Integer, HashMap<String, dd>> f3070d;

    private dv() {
        this.f3067a = new ArrayList();
        this.f3068b = new ArrayList();
        this.f3069c = new HashMap();
        this.f3070d = new HashMap();
    }

    /* renamed from: a */
    public void m4372a(da daVar) {
        m4374a(daVar.queryItems());
    }

    /* renamed from: a */
    public void m4374a(Collection<dd> collection) {
        this.f3067a.clear();
        this.f3069c.clear();
        this.f3068b.clear();
        this.f3070d.clear();
        this.f3067a.addAll(collection);
        Iterator it = this.f3067a.iterator();
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            HashMap hashMap = (HashMap) this.f3069c.get(Integer.valueOf(ddVar.f3002a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.f3069c.put(Integer.valueOf(ddVar.f3002a), hashMap);
            }
            hashMap.put(ddVar.f3003b, ddVar);
            if (!ddVar.f3005d) {
                this.f3068b.add(ddVar);
                hashMap = (HashMap) this.f3070d.get(Integer.valueOf(ddVar.f3002a));
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.f3070d.put(Integer.valueOf(ddVar.f3002a), hashMap);
                }
                hashMap.put(ddVar.f3003b, ddVar);
            }
        }
    }

    /* renamed from: a */
    public void m4373a(dd ddVar) {
        this.f3067a.add(ddVar);
        HashMap hashMap = (HashMap) this.f3069c.get(Integer.valueOf(ddVar.f3002a));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f3069c.put(Integer.valueOf(ddVar.f3002a), hashMap);
        }
        hashMap.put(ddVar.f3003b, ddVar);
        if (!ddVar.f3005d) {
            this.f3068b.add(ddVar);
            hashMap = (HashMap) this.f3070d.get(Integer.valueOf(ddVar.f3002a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.f3070d.put(Integer.valueOf(ddVar.f3002a), hashMap);
            }
            hashMap.put(ddVar.f3003b, ddVar);
        }
    }

    /* renamed from: b */
    public void m4376b(dd ddVar) {
        this.f3067a.remove(ddVar);
        HashMap hashMap = (HashMap) this.f3069c.get(Integer.valueOf(ddVar.f3002a));
        if (hashMap != null) {
            hashMap.remove(ddVar.f3003b);
        }
        if (!ddVar.f3005d) {
            this.f3068b.remove(ddVar);
            hashMap = (HashMap) this.f3070d.get(Integer.valueOf(ddVar.f3002a));
            if (hashMap != null) {
                hashMap.remove(ddVar.f3003b);
            }
        }
    }

    /* renamed from: a */
    public dd m4371a(int i, String str) {
        HashMap hashMap = (HashMap) this.f3069c.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (dd) hashMap.get(str);
    }

    /* renamed from: b */
    public dd m4375b(int i, String str) {
        HashMap hashMap = (HashMap) this.f3070d.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (dd) hashMap.get(str);
    }
}
