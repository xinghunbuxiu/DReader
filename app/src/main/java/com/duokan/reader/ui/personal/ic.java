package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.Arrays;

class ic implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ReadBook[] f8700a;
    /* renamed from: b */
    final /* synthetic */ boolean f8701b;
    /* renamed from: c */
    final /* synthetic */ ib f8702c;

    ic(ib ibVar, ReadBook[] readBookArr, boolean z) {
        this.f8702c = ibVar;
        this.f8700a = readBookArr;
        this.f8701b = z;
    }

    public void run() {
        if (this.f8702c.f8698a == 0) {
            this.f8702c.f8699b.f8685m.clear();
        }
        if (this.f8700a.length > 0) {
            this.f8702c.f8699b.f8685m.addAll(Arrays.asList(this.f8700a));
            this.f8702c.f8699b.m11970g();
        }
        if (this.f8702c.f8699b.f8692t.mo1714f() == ViewMode.Edit && this.f8702c.f8699b.k != null) {
            this.f8702c.f8699b.k.m9875c();
        }
        this.f8702c.f8699b.getAdapter().m8785a(this.f8701b);
        this.f8702c.f8699b.m11966d();
    }
}
