package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import java.util.LinkedList;
import java.util.List;

class aax implements ag<as> {
    /* renamed from: a */
    final /* synthetic */ ag f9364a;
    /* renamed from: b */
    final /* synthetic */ boolean f9365b;
    /* renamed from: c */
    final /* synthetic */ aaw f9366c;

    aax(aaw aaw, ag agVar, boolean z) {
        this.f9366c = aaw;
        this.f9364a = agVar;
        this.f9365b = z;
    }

    public /* synthetic */ void run(Object obj) {
        m13195a((as) obj);
    }

    /* renamed from: a */
    public void m13195a(as asVar) {
        if (asVar == null) {
            this.f9364a.run(null);
        } else if (this.f9366c.m13110b(asVar)) {
            this.f9364a.run(asVar);
        } else {
            ak l = asVar.mo1332l();
            asVar.mo1285H();
            if (this.f9366c.f9363d.h.mo1448b() || !this.f9366c.mo2186b(l)) {
                this.f9364a.run(null);
                return;
            }
            long[] a = this.f9366c.mo2358a(l);
            if (a.length < 1) {
                this.f9364a.run(null);
            } else if (((abd) this.f9366c.f9363d.c).mo2191c(a[0])) {
                this.f9366c.f9363d.m12892a(a[0], new aay(this, l), new aaz(this));
            } else {
                List linkedList = new LinkedList();
                for (long a2 : a) {
                    CharSequence a3 = this.f9366c.mo2356a(a2);
                    if (!TextUtils.isEmpty(a3)) {
                        linkedList.add(a3);
                    }
                }
                this.f9366c.f9363d.m12873b(linkedList, new aba(this, l));
            }
        }
    }
}
