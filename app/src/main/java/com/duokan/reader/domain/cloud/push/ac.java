package com.duokan.reader.domain.cloud.push;

class ac implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4094a;
    /* renamed from: b */
    final /* synthetic */ String f4095b;
    /* renamed from: c */
    final /* synthetic */ boolean f4096c;
    /* renamed from: d */
    final /* synthetic */ C0880y f4097d;

    ac(C0880y c0880y, String str, String str2, boolean z) {
        this.f4097d = c0880y;
        this.f4094a = str;
        this.f4095b = str2;
        this.f4096c = z;
    }

    public void run() {
        if (this.f4097d.f4169j != null) {
            this.f4097d.f4169j.mo1178a(this.f4094a, this.f4095b, this.f4096c);
        }
    }
}
