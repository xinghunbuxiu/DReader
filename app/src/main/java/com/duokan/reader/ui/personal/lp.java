package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class lp implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8897a;
    /* renamed from: b */
    final /* synthetic */ ll f8898b;

    lp(ll llVar, int i) {
        this.f8898b = llVar;
        this.f8897a = i;
    }

    public boolean onLongClick(View view) {
        this.f8898b.f8888h.mo2231c(0, this.f8897a);
        return true;
    }
}
