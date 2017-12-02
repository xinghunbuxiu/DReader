package com.duokan.reader.ui.personal;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;

class iq implements an {
    final /* synthetic */ ip a;

    iq(ip ipVar) {
        this.a = ipVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        this.a.a.pushHalfPageSmoothly(new ih(this.a.getContext(), this.a.c.c(i)), null);
    }
}
