package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.ui.general.gb;

public class fq implements gb {
    /* renamed from: a */
    protected final C0896a f10167a;
    /* renamed from: b */
    final /* synthetic */ fm f10168b;

    public fq(fm fmVar, C0896a c0896a) {
        this.f10168b = fmVar;
        this.f10167a = c0896a;
        fmVar.f10154c.mo1233d(this.f10167a);
    }

    /* renamed from: a */
    public int m14099a() {
        if (this.f10167a instanceof av) {
            return (int) this.f10168b.f10154c.mo1224b((av) this.f10167a);
        }
        return (int) this.f10168b.f10154c.mo1227c((ak) this.f10167a);
    }

    /* renamed from: b */
    public ak m14101b() {
        return m14102b(0);
    }

    /* renamed from: a */
    public gb mo2324a(int i) {
        return i == 0 ? this : this.f10168b.m14076b(m14102b(i));
    }

    /* renamed from: b */
    protected ak m14102b(int i) {
        if (this.f10167a instanceof av) {
            return this.f10168b.f10154c.mo1214a(this.f10168b.f10154c.mo1230c((av) this.f10167a), i);
        }
        return this.f10168b.f10154c.mo1214a((ak) this.f10167a, i);
    }
}
