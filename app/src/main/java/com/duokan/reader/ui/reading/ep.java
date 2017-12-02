package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.bk;
import com.duokan.core.ui.bq;

class ep implements bq {
    final /* synthetic */ en a;

    ep(en enVar) {
        this.a = enVar;
    }

    public void a(bk bkVar, View view, View view2, boolean z) {
        if (z) {
            this.a.a = this.a.d.getSelectedIndex() == 0;
            this.a.d();
        }
    }
}
