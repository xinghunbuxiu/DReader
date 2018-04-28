package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ vq f11087a;

    vr(vq vqVar) {
        this.f11087a = vqVar;
    }

    public void onClick(View view) {
        this.f11087a.f11066a.ae().m12485c(Math.max(this.f11087a.f11066a.ae().f9131e, Math.min(this.f11087a.f11066a.ae().m12525s() + 0.1f, this.f11087a.f11066a.ae().f9132f)));
        this.f11087a.f11066a.ae().m12463X();
        this.f11087a.f11066a.aB();
        this.f11087a.m15039a();
    }
}
