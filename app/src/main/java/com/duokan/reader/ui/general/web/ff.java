package com.duokan.reader.ui.general.web;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class ff implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ fd f7828a;

    ff(fd fdVar) {
        this.f7828a = fdVar;
    }

    public void onCancel(C0301c c0301c) {
        this.f7828a.f7826d.f7822b.f7581b.web_notifyWeb(this.f7828a.f7825c, 2, new Object[0]);
    }
}
