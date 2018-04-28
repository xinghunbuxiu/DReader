package com.duokan.reader.domain.cloud;

public class fo extends fr {
    /* renamed from: a */
    final /* synthetic */ fl f4011a;

    public fo(fl flVar) {
        this.f4011a = flVar;
        super(flVar);
    }

    /* renamed from: a */
    void mo1167a(fl flVar, int i) {
        flVar.m5557a(i > 0 ? new fo(this.f4011a) : new fp(this.f4011a));
    }

    /* renamed from: a */
    void mo1166a(fl flVar) {
        flVar.m5557a(new fp(this.f4011a));
    }

    public boolean equals(Object obj) {
        return obj instanceof fo;
    }
}
