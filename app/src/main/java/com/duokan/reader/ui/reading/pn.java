package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class pn implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f10800a;
    /* renamed from: b */
    final /* synthetic */ pm f10801b;

    pn(pm pmVar, int i) {
        this.f10801b = pmVar;
        this.f10800a = i;
    }

    public void onClick(View view) {
        if (this.f10801b.f10798b == null) {
            this.f10801b.m14917a(this.f10800a);
        }
    }
}
