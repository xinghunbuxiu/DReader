package com.duokan.reader.common.cache;

public class af implements y {
    private final ag a;
    private final r b;

    public af(r rVar) {
        this(rVar, m.a());
    }

    public af(r rVar, ag agVar) {
        this.b = rVar;
        this.a = agVar;
    }

    public ac a(String str, ae aeVar, int i) {
        ai[] aiVarArr = null;
        if (aeVar != null) {
            aiVarArr = aeVar.toSortOptions();
        }
        if (aiVarArr == null) {
            aiVarArr = new ai[0];
        }
        aa[] a = a();
        if (a == null) {
            a = new aa[0];
        }
        for (ai aiVar : aiVarArr) {
            if (!(aiVar.a.equals("__ITEM__KEY__") || aiVar.a.equalsIgnoreCase("rowid"))) {
                int i2;
                for (aa aaVar : a) {
                    if (aiVar.a.equals(aaVar.a)) {
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
        this.a.a(str, a, aiVarArr);
        return new ac(str, aeVar, i, this.a);
    }

    public void a(String str) {
        this.a.a(str);
    }

    private aa[] a() {
        if (this.b == null) {
            return null;
        }
        return this.b.getPropertyDefinitions();
    }
}
