package com.duokan.reader.ui.general;

import android.view.View;

class ig implements cx {
    /* renamed from: a */
    final /* synthetic */ ie f7377a;

    ig(ie ieVar) {
        this.f7377a = ieVar;
    }

    /* renamed from: a */
    public void mo1699a(int i, int i2) {
        View childAt = this.f7377a.getChildAt(i2);
        if (childAt instanceof ii) {
            ((ii) childAt).m10790a();
        }
        if (this.f7377a.f7373a != null) {
            this.f7377a.f7373a.mo1699a(i, i2);
        }
        if (this.f7377a.f7375c != null) {
            this.f7377a.f7375c.mo1699a(i, i2);
        }
    }
}
