package com.duokan.reader.domain.cloud;

public class gm extends gl {
    final /* synthetic */ gf a;

    public gm(gf gfVar) {
        this.a = gfVar;
        super(gfVar);
    }

    void a(gf gfVar, int i) {
        if (i < 1) {
            gfVar.a(new gj(this.a));
        } else {
            gfVar.a(new gi(this.a));
        }
    }

    void a(gf gfVar) {
        gfVar.a(new gj(this.a));
    }

    public boolean equals(Object obj) {
        return obj instanceof gm;
    }
}
