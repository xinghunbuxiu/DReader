package com.duokan.reader.ui.account;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class bk implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ bi f5871a;

    bk(bi biVar) {
        this.f5871a = biVar;
    }

    public void onCancel(C0301c c0301c) {
        if (!this.f5871a.c.isShareFinish()) {
            this.f5871a.f = false;
            this.f5871a.d.setEnabled(true);
            this.f5871a.c.updateShareCancel();
        }
    }
}
