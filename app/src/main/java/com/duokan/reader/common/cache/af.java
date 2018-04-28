package com.duokan.reader.common.cache;

public class af<TItem, TItemJson> implements C0569y<TItem, ad<TItem>, ae<TItem>> {
    /* renamed from: a */
    private final ag f1860a;
    /* renamed from: b */
    private final C0444r<TItem, TItemJson> f1861b;

    public af(C0444r<TItem, TItemJson> c0444r) {
        this(c0444r, C0579m.m2592a());
    }

    public af(C0444r<TItem, TItemJson> c0444r, ag agVar) {
        this.f1861b = c0444r;
        this.f1860a = agVar;
    }

    /* renamed from: a */
    public ac<TItem> m2523a(String str, ae<TItem> aeVar, int i) {
        ai[] aiVarArr = null;
        if (aeVar != null) {
            aiVarArr = aeVar.toSortOptions();
        }
        if (aiVarArr == null) {
            aiVarArr = new ai[0];
        }
        aa[] a = m2522a();
        if (a == null) {
            a = new aa[0];
        }
        for (ai aiVar : aiVarArr) {
            if (!(aiVar.f1869a.equals("__ITEM__KEY__") || aiVar.f1869a.equalsIgnoreCase("rowid"))) {
                int i2;
                for (aa aaVar : a) {
                    if (aiVar.f1869a.equals(aaVar.f1854a)) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.f1860a.m2556a(str, a, aiVarArr);
        return new ac(str, aeVar, i, this.f1860a);
    }

    /* renamed from: a */
    public void mo768a(String str) {
        this.f1860a.m2553a(str);
    }

    /* renamed from: a */
    private aa[] m2522a() {
        if (this.f1861b == null) {
            return null;
        }
        return this.f1861b.getPropertyDefinitions();
    }
}
