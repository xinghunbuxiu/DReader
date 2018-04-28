package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.document.C0897d;

class og implements bf {
    /* renamed from: a */
    final /* synthetic */ nu f10735a;

    og(nu nuVar) {
        this.f10735a = nuVar;
    }

    /* renamed from: a */
    public void mo480a(ay ayVar, View view, int i) {
        this.f10735a.f10700b.aP();
        C0798a c0798a = (C0798a) ayVar.getAdapter().mo509d(i);
        this.f10735a.f10700b.mo2131d(this.f10735a.f10700b.getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e()));
    }
}
