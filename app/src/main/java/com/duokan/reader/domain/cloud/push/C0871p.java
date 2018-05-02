package com.duokan.reader.domain.cloud.push;

/* renamed from: com.duokan.reader.domain.cloud.push.p */
class C0871p implements ag {
    /* renamed from: a */
    final /* synthetic */ ag f4143a;
    /* renamed from: b */
    final /* synthetic */ C0857b f4144b;

    C0871p(C0857b c0857b, ag agVar) {
        this.f4144b = c0857b;
        this.f4143a = agVar;
    }

    /* renamed from: a */
    public void mo1184a(boolean z) {
        if (this.f4143a != null) {
            this.f4143a.mo1184a(z);
        }
        if (z) {
            this.f4144b.m5692d("black_list");
        } else {
            this.f4144b.m5690c("black_list");
        }
    }

    /* renamed from: a */
    public void mo1183a(String str) {
        if (this.f4143a != null) {
            this.f4143a.mo1183a(str);
        }
    }
}
