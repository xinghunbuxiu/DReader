package com.duokan.reader.domain.cloud.push;

/* renamed from: com.duokan.reader.domain.cloud.push.z */
class C0881z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f4170a;
    /* renamed from: b */
    final /* synthetic */ String f4171b;
    /* renamed from: c */
    final /* synthetic */ String f4172c;
    /* renamed from: d */
    final /* synthetic */ C0880y f4173d;

    C0881z(C0880y c0880y, long j, String str, String str2) {
        this.f4173d = c0880y;
        this.f4170a = j;
        this.f4171b = str;
        this.f4172c = str2;
    }

    public void run() {
        if (this.f4173d.f4169j != null) {
            this.f4173d.f4169j.mo1175a(this.f4170a, this.f4171b, this.f4172c);
        }
    }
}
