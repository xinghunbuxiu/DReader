package com.duokan.reader.domain.cloud;

public class gi extends gl {
    final /* synthetic */ gf a;

    public gi(gf gfVar) {
        this.a = gfVar;
        super(gfVar);
    }

    void a(gf gfVar, int i) {
        gfVar.a(i > 0 ? new gi(this.a) : new gj(this.a));
    }

    void a(gf gfVar) {
        gfVar.a(new gj(this.a));
    }

    public boolean equals(Object obj) {
        return obj instanceof gi;
    }
}
