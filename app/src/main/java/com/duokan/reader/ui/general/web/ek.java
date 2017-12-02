package com.duokan.reader.ui.general.web;

import com.duokan.core.ui.j;
import com.duokan.core.ui.l;

class ek implements l {
    final /* synthetic */ eh a;

    ek(eh ehVar) {
        this.a = ehVar;
    }

    public void onDismiss(j jVar) {
        if (!this.a.e.b.b.mCallBackSucceed) {
            this.a.d.b(new Object[0]);
        }
    }
}
