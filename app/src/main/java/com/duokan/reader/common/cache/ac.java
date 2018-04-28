package com.duokan.reader.common.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class ac<TItem> implements C0568w<TItem, ad<TItem>, ae<TItem>> {
    /* renamed from: a */
    private final ag f1856a;
    /* renamed from: b */
    private final String f1857b;
    /* renamed from: c */
    private final ae<TItem> f1858c;
    /* renamed from: d */
    private final int f1859d;

    /* renamed from: a */
    public /* synthetic */ Comparator mo759a() {
        return m2518e();
    }

    public ac(String str, ae<TItem> aeVar, int i, ag agVar) {
        this.f1857b = str;
        this.f1858c = aeVar;
        this.f1859d = i;
        this.f1856a = agVar;
    }

    /* renamed from: e */
    public ae<TItem> m2518e() {
        return this.f1858c;
    }

    /* renamed from: b */
    public int mo762b() {
        return this.f1859d;
    }

    /* renamed from: c */
    public int mo764c() {
        return this.f1856a.m2557b(this.f1857b);
    }

    /* renamed from: d */
    public String mo766d() {
        return this.f1856a.m2559c(this.f1857b);
    }

    /* renamed from: a */
    public Collection<String> m2507a(ad<TItem> adVar, ae<TItem> aeVar, C0582t c0582t) {
        return this.f1856a.m2551a(this.f1857b, m2502a((ad) adVar), m2503a((ae) aeVar), c0582t);
    }

    /* renamed from: b */
    public Collection<C0584z> m2513b(ad<TItem> adVar, ae<TItem> aeVar, C0582t c0582t) {
        return this.f1856a.m2558b(this.f1857b, m2502a((ad) adVar), m2503a((ae) aeVar), c0582t);
    }

    /* renamed from: c */
    public Collection<C0584z> m2516c(ad<TItem> adVar, ae<TItem> aeVar, C0582t c0582t) {
        return this.f1856a.m2560c(this.f1857b, m2502a((ad) adVar), m2503a((ae) aeVar), c0582t);
    }

    /* renamed from: a */
    public Collection<String> mo757a(int i) {
        ai[] aiVarArr = null;
        if (this.f1858c != null) {
            aiVarArr = this.f1858c.toSortOptions();
        }
        return this.f1856a.m2552a(this.f1857b, aiVarArr, i);
    }

    /* renamed from: a */
    public C0584z mo756a(String str) {
        return this.f1856a.m2550a(this.f1857b, str);
    }

    /* renamed from: a */
    public void mo761a(Collection<String> collection) {
        this.f1856a.m2555a(this.f1857b, (Collection) collection);
    }

    /* renamed from: a */
    public void mo760a(ArrayList<C0583x> arrayList) {
        this.f1856a.m2554a(this.f1857b, (ArrayList) arrayList);
    }

    /* renamed from: a */
    private ai[] m2503a(ae<TItem> aeVar) {
        if (aeVar == null) {
            return null;
        }
        return aeVar.toSortOptions();
    }

    /* renamed from: a */
    private ah m2502a(ad<TItem> adVar) {
        if (adVar == null) {
            return null;
        }
        return adVar.mo1185a();
    }
}
