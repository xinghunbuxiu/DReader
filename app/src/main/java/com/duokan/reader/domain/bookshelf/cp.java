package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class cp {
    /* renamed from: a */
    public final ArrayList<bt> f2980a;
    /* renamed from: b */
    public final ArrayList<bt> f2981b;
    /* renamed from: c */
    public final HashMap<Integer, HashMap<String, bt>> f2982c;
    /* renamed from: d */
    public final HashMap<Integer, HashMap<String, bt>> f2983d;

    private cp() {
        this.f2980a = new ArrayList();
        this.f2981b = new ArrayList();
        this.f2982c = new HashMap();
        this.f2983d = new HashMap();
    }

    /* renamed from: a */
    public void m4278a(bq bqVar) {
        m4280a(bqVar.queryItems());
    }

    /* renamed from: a */
    public void m4280a(Collection<bt> collection) {
        this.f2980a.clear();
        this.f2982c.clear();
        this.f2981b.clear();
        this.f2983d.clear();
        this.f2980a.addAll(collection);
        Iterator it = this.f2980a.iterator();
        while (it.hasNext()) {
            bt btVar = (bt) it.next();
            HashMap hashMap = (HashMap) this.f2982c.get(Integer.valueOf(btVar.f2857a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.f2982c.put(Integer.valueOf(btVar.f2857a), hashMap);
            }
            hashMap.put(btVar.f2858b, btVar);
            if (!btVar.m4070c()) {
                this.f2981b.add(btVar);
                hashMap = (HashMap) this.f2983d.get(Integer.valueOf(btVar.f2857a));
                if (hashMap == null) {
                    hashMap = new HashMap();
                    this.f2983d.put(Integer.valueOf(btVar.f2857a), hashMap);
                }
                hashMap.put(btVar.f2858b, btVar);
            }
        }
    }

    /* renamed from: a */
    public void m4279a(bt btVar) {
        this.f2980a.add(btVar);
        HashMap hashMap = (HashMap) this.f2982c.get(Integer.valueOf(btVar.f2857a));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f2982c.put(Integer.valueOf(btVar.f2857a), hashMap);
        }
        hashMap.put(btVar.f2858b, btVar);
        if (!btVar.m4070c()) {
            this.f2981b.add(btVar);
            hashMap = (HashMap) this.f2983d.get(Integer.valueOf(btVar.f2857a));
            if (hashMap == null) {
                hashMap = new HashMap();
                this.f2983d.put(Integer.valueOf(btVar.f2857a), hashMap);
            }
            hashMap.put(btVar.f2858b, btVar);
        }
    }

    /* renamed from: b */
    public void m4281b(bt btVar) {
        this.f2980a.remove(btVar);
        HashMap hashMap = (HashMap) this.f2982c.get(Integer.valueOf(btVar.f2857a));
        if (hashMap != null) {
            hashMap.remove(btVar.f2858b);
        }
        if (!btVar.m4070c()) {
            this.f2981b.remove(btVar);
            hashMap = (HashMap) this.f2983d.get(Integer.valueOf(btVar.f2857a));
            if (hashMap != null) {
                hashMap.remove(btVar.f2858b);
            }
        }
    }

    /* renamed from: a */
    public bt m4277a(int i, String str) {
        HashMap hashMap = (HashMap) this.f2982c.get(Integer.valueOf(i));
        if (hashMap == null) {
            return null;
        }
        return (bt) hashMap.get(str);
    }
}
