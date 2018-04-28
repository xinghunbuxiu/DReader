package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.ui.general.gb;

public class fx implements gb {
    /* renamed from: a */
    protected final C0896a f10191a;
    /* renamed from: b */
    final /* synthetic */ fs f10192b;

    public fx(fs fsVar, C0896a c0896a) {
        this.f10192b = fsVar;
        this.f10191a = c0896a;
        fsVar.f10174b.mo1233d(this.f10191a);
    }

    /* renamed from: a */
    public ak m14152a() {
        return m14154b(0);
    }

    /* renamed from: a */
    public gb mo2324a(int i) {
        if (i == 0) {
            return this.f10192b.mo2517b(this.f10191a);
        }
        return this.f10192b.mo2517b(m14154b(i));
    }

    /* renamed from: b */
    protected ak m14154b(int i) {
        ak b;
        if (this.f10191a instanceof av) {
            C0903n a = this.f10192b.f10174b;
            if (this.f10192b.f10180h) {
                b = this.f10192b.f10174b.m5915b(this.f10191a);
            } else {
                b = this.f10192b.f10174b.m5896a(this.f10191a);
            }
            return a.mo1214a(b, i);
        }
        a = this.f10192b.f10174b;
        if (this.f10192b.f10180h) {
            b = this.f10192b.f10174b.m5915b(this.f10191a);
        } else {
            b = this.f10192b.f10174b.m5896a(this.f10191a);
        }
        return a.mo1214a(b, i);
    }
}
