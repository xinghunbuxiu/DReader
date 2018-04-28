package com.duokan.reader.ui.general;

import com.duokan.core.ui.TabBarView;

class ic implements ih {
    /* renamed from: a */
    final /* synthetic */ TabBarView f7369a;
    /* renamed from: b */
    final /* synthetic */ ib f7370b;

    ic(ib ibVar, TabBarView tabBarView) {
        this.f7370b = ibVar;
        this.f7369a = tabBarView;
    }

    /* renamed from: a */
    public void mo1794a(float f, int i) {
        this.f7370b.m10772a(i, false);
        if (this.f7370b.f7367d != null) {
            this.f7370b.f7367d.mo1794a(f, i);
        }
    }

    /* renamed from: a */
    public void mo1699a(int i, int i2) {
        this.f7369a.m1319a(i2);
        this.f7370b.m10772a(i2, false);
        if (this.f7370b.f7367d != null) {
            this.f7370b.f7367d.mo1699a(i, i2);
        }
    }
}
