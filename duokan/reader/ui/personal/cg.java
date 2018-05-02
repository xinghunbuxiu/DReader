package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class cg implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ ce b;

    cg(ce ceVar, int i) {
        this.b = ceVar;
        this.a = i;
    }

    public boolean onLongClick(View view) {
        this.b.a.h.a(0, this.a);
        return true;
    }
}
