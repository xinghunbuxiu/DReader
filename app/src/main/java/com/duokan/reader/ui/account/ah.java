package com.duokan.reader.ui.account;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;

class ah implements bf {
    /* renamed from: a */
    final /* synthetic */ ae f5786a;
    /* renamed from: b */
    final /* synthetic */ ag f5787b;

    ah(ag agVar, ae aeVar) {
        this.f5787b = agVar;
        this.f5786a = aeVar;
    }

    /* renamed from: a */
    public void mo480a(ay ayVar, View view, int i) {
        if (this.f5786a != null) {
            this.f5786a.onChoiced(this.f5787b.f5784b.m8864a(i).f5780b);
        }
    }
}
