package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class ff implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ fd b;

    ff(fd fdVar, int i) {
        this.b = fdVar;
        this.a = i;
    }

    public boolean onLongClick(View view) {
        this.b.e.a(this.b.c(), this.a);
        return true;
    }
}
