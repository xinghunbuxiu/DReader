package com.duokan.reader.ui.general.web;

import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.OnDismissListener;

class ev implements OnDismissListener {
    /* renamed from: a */
    final /* synthetic */ es f7803a;

    ev(es esVar) {
        this.f7803a = esVar;
    }

    public void onDismiss(C0342j c0342j) {
        if (!this.f7803a.f7800e.f7793b.f7581b.mCallBackSucceed) {
            this.f7803a.f7799d.mo1840b(new Object[0]);
        }
    }
}
