package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class kz implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ kx c;

    kz(kx kxVar, int i, int i2) {
        this.c = kxVar;
        this.a = i;
        this.b = i2;
    }

    public boolean onLongClick(View view) {
        this.c.h.c(this.a, this.b);
        return true;
    }
}
