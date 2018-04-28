package com.duokan.reader.ui.general;

import com.duokan.core.ui.cs;

class id implements cs {
    /* renamed from: a */
    final /* synthetic */ ie f7371a;
    /* renamed from: b */
    final /* synthetic */ ib f7372b;

    id(ib ibVar, ie ieVar) {
        this.f7372b = ibVar;
        this.f7371a = ieVar;
    }

    /* renamed from: a */
    public void mo1697a(int i, int i2, boolean z) {
    }

    /* renamed from: b */
    public void mo1698b(int i, int i2, boolean z) {
        if (!z) {
            return;
        }
        if (this.f7371a.getShowingChildIndex() != i2) {
            this.f7371a.m9070b(i2);
        } else if (this.f7372b.f7367d != null) {
            this.f7372b.f7367d.mo1699a(i, i2);
        }
    }
}
