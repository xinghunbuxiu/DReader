package com.duokan.reader.common.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class ac implements w {
    private final ag a;
    private final String b;
    private final ae c;
    private final int d;

    public /* synthetic */ Comparator a() {
        return e();
    }

    public ac(String str, ae aeVar, int i, ag agVar) {
        this.b = str;
        this.c = aeVar;
        this.d = i;
        this.a = agVar;
    }

    public ae e() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.a.b(this.b);
    }

    public String d() {
        return this.a.c(this.b);
    }

    public Collection a(ad adVar, ae aeVar, t tVar) {
        return this.a.a(this.b, a(adVar), a(aeVar), tVar);
    }

    public Collection b(ad adVar, ae aeVar, t tVar) {
        return this.a.b(this.b, a(adVar), a(aeVar), tVar);
    }

    public Collection c(ad adVar, ae aeVar, t tVar) {
        return this.a.c(this.b, a(adVar), a(aeVar), tVar);
    }

    public Collection a(int i) {
        ai[] aiVarArr = null;
        if (this.c != null) {
            aiVarArr = this.c.toSortOptions();
        }
        return this.a.a(this.b, aiVarArr, i);
    }

    public z a(String str) {
        return this.a.a(this.b, str);
    }

    public void a(Collection collection) {
        this.a.a(this.b, collection);
    }

    public void a(ArrayList arrayList) {
        this.a.a(this.b, arrayList);
    }

    private ai[] a(ae aeVar) {
        if (aeVar == null) {
            return null;
        }
        return aeVar.toSortOptions();
    }

    private ah a(ad adVar) {
        if (adVar == null) {
            return null;
        }
        return adVar.a();
    }
}
