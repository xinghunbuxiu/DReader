package com.duokan.reader.ui.general;

import com.duokan.core.app.ActivatedController;

class in implements ia {
    /* renamed from: a */
    final /* synthetic */ ik f7388a;

    in(ik ikVar) {
        this.f7388a = ikVar;
    }

    /* renamed from: a */
    public void mo1798a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            ActivatedController c0303e = (ActivatedController) this.f7388a.f7384b.get(i2);
            this.f7388a.deactivate((ActivatedController) this.f7388a.f7384b.get(i));
            this.f7388a.activate(c0303e);
        }
    }
}
