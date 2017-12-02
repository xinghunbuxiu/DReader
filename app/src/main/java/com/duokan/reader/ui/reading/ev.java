package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.bk;
import com.duokan.core.ui.bq;

class ev implements bq {
    final /* synthetic */ et a;

    ev(et etVar) {
        this.a = etVar;
    }

    public void a(bk bkVar, View view, View view2, boolean z) {
        if (z) {
            this.a.a = this.a.d.getSelectedIndex() == 0;
            this.a.d();
        }
    }
}
