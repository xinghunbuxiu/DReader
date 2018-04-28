package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppManage;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.ui.dv;

class pv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ pu f10836a;

    pv(pu puVar) {
        this.f10836a = puVar;
    }

    public void run() {
        ((BaseActivity) AppManage.getCurrentActivity(this.f10836a.f10835b.f10833j.getContext())).unlockCurrentOrientation();
        this.f10836a.f10835b.f10825b.setVisibility(4);
        this.f10836a.f10835b.f10833j.f10798b.dismiss();
        this.f10836a.f10835b.f10833j.f10798b = null;
        this.f10836a.f10835b.f10833j.f10799c = false;
        dv.f1204m.m816a(true);
    }
}
