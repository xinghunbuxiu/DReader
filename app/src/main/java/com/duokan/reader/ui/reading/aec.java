package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import java.util.Arrays;

class aec implements ag<as> {
    /* renamed from: a */
    final /* synthetic */ ak f9566a;
    /* renamed from: b */
    final /* synthetic */ aeb f9567b;

    aec(aeb aeb, ak akVar) {
        this.f9567b = aeb;
        this.f9566a = akVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13454a((as) obj);
    }

    /* renamed from: a */
    public void m13454a(as asVar) {
        afa afa;
        C0896a c0896a = null;
        if (asVar != null) {
            afa = new afa();
            afa.f9612a = this.f9566a;
            afa.f9613b.addAll(Arrays.asList(this.f9567b.f9565d.m13416a(asVar)));
            asVar.mo1285H();
            this.f9567b.f9565d.m13406a(afa);
            this.f9567b.f9562a.f9614c = afa.f9614c;
        }
        afa = this.f9567b.f9562a;
        if (!this.f9567b.f9565d.f9541a.mo2139e(this.f9566a)) {
            c0896a = this.f9567b.f9565d.f9542b.mo1237f(this.f9566a);
        }
        afa.f9612a = c0896a;
        this.f9567b.f9565d.m13406a(this.f9567b.f9562a);
        this.f9567b.f9563b.run(this.f9567b.f9562a);
    }
}
