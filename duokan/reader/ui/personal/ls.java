package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ls implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ lq c;

    ls(lq lqVar, int i, int i2) {
        this.c = lqVar;
        this.a = i;
        this.b = i2;
    }

    public boolean onLongClick(View view) {
        this.c.i.c(this.a, this.b);
        return true;
    }
}
