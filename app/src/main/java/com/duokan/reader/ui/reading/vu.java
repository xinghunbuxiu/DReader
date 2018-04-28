package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vu implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ vq f11090a;

    vu(vq vqVar) {
        this.f11090a = vqVar;
    }

    public void onClick(View view) {
        this.f11090a.f11066a.ae().m12490d(Math.max(this.f11090a.f11066a.ae().f9133g, Math.min(this.f11090a.f11066a.ae().m12526t() + 0.1f, this.f11090a.f11066a.ae().f9134h)));
        this.f11090a.f11066a.ae().m12463X();
        this.f11090a.f11066a.aB();
        this.f11090a.m15039a();
    }
}
