package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.push.C0876u;
import com.duokan.reader.domain.cloud.push.C0879x;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cq implements C0879x {
    /* renamed from: a */
    final /* synthetic */ int f8415a;
    /* renamed from: b */
    final /* synthetic */ long f8416b;
    /* renamed from: c */
    final /* synthetic */ cm f8417c;

    cq(cm cmVar, int i, long j) {
        this.f8417c = cmVar;
        this.f8415a = i;
        this.f8416b = j;
    }

    /* renamed from: a */
    public void mo1894a(C0876u[] c0876uArr, boolean z) {
        if (this.f8415a == 0 && this.f8416b == 0) {
            this.f8417c.f8408a.f8402b.clear();
        }
        for (Object add : c0876uArr) {
            this.f8417c.f8408a.f8402b.add(add);
        }
        if (this.f8417c.getViewMode() == ViewMode.Edit && this.f8417c.k != null) {
            this.f8417c.k.m9875c();
        }
        this.f8417c.getAdapter().m8785a(z);
    }
}
