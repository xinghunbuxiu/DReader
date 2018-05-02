package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.ui.general.expandable.ViewMode;

import java.util.Arrays;

class hp implements Runnable {
    final /* synthetic */ ReadBook[] a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ho c;

    hp(ho hoVar, ReadBook[] readBookArr, boolean z) {
        this.c = hoVar;
        this.a = readBookArr;
        this.b = z;
    }

    public void run() {
        if (this.c.a == 0) {
            this.c.b.l.clear();
        }
        if (this.a.length > 0) {
            this.c.b.l.addAll(Arrays.asList(this.a));
            this.c.b.g();
        }
        if (this.c.b.s.f() == ViewMode.Edit && this.c.b.j != null) {
            this.c.b.j.c();
        }
        this.c.b.getAdapter().a(this.b);
        this.c.b.d();
    }
}
