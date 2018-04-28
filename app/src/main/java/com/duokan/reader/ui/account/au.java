package com.duokan.reader.ui.account;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class au implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ at f5836a;

    au(at atVar) {
        this.f5836a = atVar;
    }

    public void onCancel(C0301c c0301c) {
        if (!this.f5836a.c.isShareFinish()) {
            this.f5836a.f = false;
            this.f5836a.d.setEnabled(true);
            this.f5836a.c.updateShareCancel();
        }
    }
}
