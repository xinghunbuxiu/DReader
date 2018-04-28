package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.p041a.C0670f;
import java.lang.ref.WeakReference;

class ua implements C0670f {
    /* renamed from: a */
    private final WeakReference<tp> f11003a;

    ua(tp tpVar) {
        this.f11003a = new WeakReference(tpVar);
    }

    /* renamed from: a */
    public void mo2509a(int i) {
        tp tpVar = (tp) this.f11003a.get();
        if (tpVar != null) {
            tpVar.m13606b(i);
        }
    }

    /* renamed from: a */
    public void mo2510a(String str) {
    }
}
