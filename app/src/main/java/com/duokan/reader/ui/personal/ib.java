package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.ee;

class ib implements ee {
    /* renamed from: a */
    final /* synthetic */ int f8698a;
    /* renamed from: b */
    final /* synthetic */ hy f8699b;

    ib(hy hyVar, int i) {
        this.f8699b = hyVar;
        this.f8698a = i;
    }

    /* renamed from: a */
    public void mo1157a(ReadBook[] readBookArr, boolean z, boolean z2) {
        this.f8699b.f8693u = !z;
        this.f8699b.m11977a(new ic(this, readBookArr, z));
    }

    /* renamed from: a */
    public void mo1156a(String str) {
        this.f8699b.f8693u = false;
        this.f8699b.getAdapter().m8790m();
    }
}
