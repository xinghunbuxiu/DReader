package com.duokan.reader.ui.reading;

import com.duokan.reader.common.bitmap.C0544a;

class aw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aq f9808a;

    aw(aq aqVar) {
        this.f9808a = aqVar;
    }

    public void run() {
        this.f9808a.f9798q = false;
        if (!this.f9808a.f9782a.mo1994K()) {
            this.f9808a.f9799r = 0;
            this.f9808a.f9793l = C0544a.m2438a(this.f9808a.f9782a.mo2007X().mo2328d());
            this.f9808a.f9801t = (float) this.f9808a.f9790i;
            this.f9808a.f9784c.invalidate();
            this.f9808a.f9782a.mo2179u();
        }
    }
}
