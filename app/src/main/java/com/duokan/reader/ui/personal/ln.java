package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ln implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8892a;
    /* renamed from: b */
    final /* synthetic */ int f8893b;
    /* renamed from: c */
    final /* synthetic */ ll f8894c;

    ln(ll llVar, int i, int i2) {
        this.f8894c = llVar;
        this.f8892a = i;
        this.f8893b = i2;
    }

    public boolean onLongClick(View view) {
        this.f8894c.f8888h.mo2231c(this.f8892a, this.f8893b);
        return true;
    }
}
