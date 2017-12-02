package com.duokan.reader.ui.general;

import com.duokan.core.app.c;
import com.duokan.core.app.d;
import com.duokan.reader.common.k;

class hv implements d {
    final /* synthetic */ k a;
    final /* synthetic */ hs b;

    hv(hs hsVar, k kVar) {
        this.b = hsVar;
        this.a = kVar;
    }

    public void onCancel(c cVar) {
        this.a.a(Boolean.valueOf(true));
    }
}
