package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class lb implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ kx b;

    lb(kx kxVar, int i) {
        this.b = kxVar;
        this.a = i;
    }

    public boolean onLongClick(View view) {
        this.b.h.c(0, this.a);
        return true;
    }
}
