package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.general.dj;

class bo implements dj {
    /* renamed from: a */
    final /* synthetic */ bh f8339a;
    /* renamed from: b */
    final /* synthetic */ bn f8340b;

    bo(bn bnVar, bh bhVar) {
        this.f8340b = bnVar;
        this.f8339a = bhVar;
    }

    public boolean onBack() {
        this.f8340b.dismiss();
        return true;
    }
}
