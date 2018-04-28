package com.duokan.reader.ui.account;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class ba implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ ay f5854a;

    ba(ay ayVar) {
        this.f5854a = ayVar;
    }

    public void onCancel(C0301c c0301c) {
        if (!this.f5854a.c.isShareFinish()) {
            this.f5854a.f = false;
            this.f5854a.d.setEnabled(true);
            this.f5854a.c.updateShareCancel();
        }
    }
}
