package com.duokan.reader.domain.cloud;

public class fs extends fr {
    /* renamed from: a */
    final /* synthetic */ fl f4013a;

    public fs(fl flVar) {
        this.f4013a = flVar;
        super(flVar);
    }

    /* renamed from: a */
    void mo1167a(fl flVar, int i) {
        if (i < 1) {
            flVar.m5557a(new fp(this.f4013a));
        } else {
            flVar.m5557a(new fo(this.f4013a));
        }
    }

    /* renamed from: a */
    void mo1166a(fl flVar) {
        flVar.m5557a(new fp(this.f4013a));
    }

    public boolean equals(Object obj) {
        return obj instanceof fs;
    }
}
