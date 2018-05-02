package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class hv implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ hs c;

    hv(hs hsVar, int i, int i2) {
        this.c = hsVar;
        this.a = i;
        this.b = i2;
    }

    public boolean onLongClick(View view) {
        this.c.a.c(this.a, this.b);
        return true;
    }
}
