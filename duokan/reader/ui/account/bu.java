package com.duokan.reader.ui.account;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class bu implements d {
    final /* synthetic */ bs a;

    bu(bs bsVar) {
        this.a = bsVar;
    }

    public void onCancel(c cVar) {
        if (!this.a.a.isShareFinish()) {
            this.a.d = false;
            this.a.b.setEnabled(true);
            this.a.a.updateShareCancel();
        }
    }
}
