package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class mg implements OnLongClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8936a;
    /* renamed from: b */
    final /* synthetic */ int f8937b;
    /* renamed from: c */
    final /* synthetic */ me f8938c;

    mg(me meVar, int i, int i2) {
        this.f8938c = meVar;
        this.f8936a = i;
        this.f8937b = i2;
    }

    public boolean onLongClick(View view) {
        this.f8938c.f8930i.mo2231c(this.f8936a, this.f8937b);
        return true;
    }
}
