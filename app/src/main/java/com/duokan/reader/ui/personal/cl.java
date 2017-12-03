package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;

class cl extends cc {
    final /* synthetic */ ck a;

    cl(ck ckVar, IFeature featrue) {
        this.a = ckVar;
        super(featrue);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        this.a.d.getPagerView().setTabEnabled(false);
    }

    public void b() {
        super.b();
        this.a.d.getPagerView().setTabEnabled(true);
    }
}
