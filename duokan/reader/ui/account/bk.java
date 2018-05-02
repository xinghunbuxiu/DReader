package com.duokan.reader.ui.account;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

class bk implements d {
    final /* synthetic */ bi a;

    bk(bi biVar) {
        this.a = biVar;
    }

    public void onCancel(c cVar) {
        if (!this.a.a.isShareFinish()) {
            this.a.d = false;
            this.a.b.setEnabled(true);
            this.a.a.updateShareCancel();
        }
    }
}
