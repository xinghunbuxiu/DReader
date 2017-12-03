package com.duokan.reader.ui.reading;

import com.duokan.core.app.TansFormUtils;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.ui.UTools;

class pl implements Runnable {
    final /* synthetic */ pk a;

    pl(pk pkVar) {
        this.a = pkVar;
    }

    public void run() {
        ((BaseActivity) TansFormUtils.getContext(this.a.b.j.getContext())).unlockCurrentOrientation();
        this.a.b.b.setVisibility(4);
        this.a.b.j.b.dismiss();
        this.a.b.j.b = null;
        this.a.b.j.c = false;
        UTools.m.a(true);
    }
}
