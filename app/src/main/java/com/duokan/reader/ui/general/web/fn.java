package com.duokan.reader.ui.general.web;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class fn implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ fl f7843a;

    fn(fl flVar) {
        this.f7843a = flVar;
    }

    public void onCancel(C0301c c0301c) {
        this.f7843a.f7841d.f7837b.f7581b.web_notifyWeb(this.f7843a.f7840c, 2, new Object[0]);
    }
}
