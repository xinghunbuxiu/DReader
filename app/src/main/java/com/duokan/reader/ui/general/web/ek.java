package com.duokan.reader.ui.general.web;

import com.duokan.core.ui.OnDismissListener;
import com.duokan.core.ui.j;

class ek implements OnDismissListener {
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
