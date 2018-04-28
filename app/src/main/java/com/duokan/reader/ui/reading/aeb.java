package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;
import java.util.Arrays;
import java.util.ListIterator;

class aeb implements ag<as> {
    /* renamed from: a */
    final /* synthetic */ afa f9562a;
    /* renamed from: b */
    final /* synthetic */ ag f9563b;
    /* renamed from: c */
    final /* synthetic */ C0896a f9564c;
    /* renamed from: d */
    final /* synthetic */ adz f9565d;

    aeb(adz adz, afa afa, ag agVar, C0896a c0896a) {
        this.f9565d = adz;
        this.f9562a = afa;
        this.f9563b = agVar;
        this.f9564c = c0896a;
    }

    public /* synthetic */ void run(Object obj) {
        m13453a((as) obj);
    }

    /* renamed from: a */
    public void m13453a(as asVar) {
        if (asVar == null) {
            this.f9562a.f9612a = null;
            this.f9563b.run(this.f9562a);
            return;
        }
        ak l = asVar.mo1332l();
        this.f9562a.f9613b.addAll(Arrays.asList(this.f9565d.m13416a(asVar)));
        asVar.mo1285H();
        if (!(this.f9564c instanceof av) || this.f9565d.f9541a.mo2135d(l) || this.f9562a.f9613b.isEmpty() || !((afc) this.f9562a.f9613b.getFirst()).f9622b.mo1199h().mo1190c(this.f9564c) || this.f9565d.f9541a == null) {
            this.f9562a.f9612a = this.f9565d.f9541a.mo2139e(l) ? null : this.f9565d.f9542b.mo1237f(l);
            this.f9565d.m13406a(this.f9562a);
            if (this.f9564c instanceof av) {
                ListIterator listIterator = this.f9562a.f9613b.listIterator();
                while (listIterator.hasNext() && !((afc) listIterator.next()).f9622b.mo1199h().mo1190c(this.f9564c)) {
                    listIterator.remove();
                }
            }
            this.f9563b.run(this.f9562a);
            return;
        }
        this.f9565d.f9541a.mo2022a(this.f9565d.f9542b.mo1239g(l), true, new aec(this, l));
    }
}
