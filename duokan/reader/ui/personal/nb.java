package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnLongClickListener;

class nb implements OnLongClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ mz b;

    nb(mz mzVar, int i) {
        this.b = mzVar;
        this.a = i;
    }

    public boolean onLongClick(View view) {
        this.b.e.a(this.b.c(), this.a);
        return true;
    }
}
