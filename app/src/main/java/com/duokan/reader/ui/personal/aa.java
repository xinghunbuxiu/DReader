package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.general.ia;

class aa implements ia {
    /* renamed from: a */
    final /* synthetic */ C1416x f8239a;

    aa(C1416x c1416x) {
        this.f8239a = c1416x;
    }

    /* renamed from: a */
    public void mo1798a(int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            ActivatedController a = this.f8239a.m12391a(i);
            ActivatedController a2 = this.f8239a.m12391a(i2);
            this.f8239a.deactivate(a);
            this.f8239a.activate(a2);
        }
    }
}
