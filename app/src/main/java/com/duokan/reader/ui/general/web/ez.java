package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ez implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f7814a;
    /* renamed from: b */
    final /* synthetic */ ci f7815b;

    ez(ci ciVar, boolean z) {
        this.f7815b = ciVar;
        this.f7814a = z;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7815b.f7581b.mHasBar == null || this.f7815b.f7581b.mHasBar.booleanValue() != this.f7814a) {
            this.f7815b.f7581b.mHasBar = Boolean.valueOf(this.f7814a);
            this.f7815b.f7581b.updateBarStatus();
        }
    }
}
