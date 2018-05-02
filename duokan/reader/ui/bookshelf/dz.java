package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class dz implements OnFocusChangeListener {
    final /* synthetic */ du a;

    dz(du duVar) {
        this.a = duVar;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.a.i = true;
            this.a.h.setVisibility(0);
            a.a(this.a.g, 300, null);
            a.a(this.a.h, 0.0f, 1.0f, 300, Boolean.valueOf(false), null);
            return;
        }
        this.a.i = false;
        this.a.e();
    }
}
