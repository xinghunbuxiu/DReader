package com.duokan.reader.ui.personal;

import com.duokan.core.sys.t;

import java.util.ArrayList;

class ne implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ nc b;

    ne(nc ncVar, ArrayList arrayList) {
        this.b = ncVar;
        this.a = arrayList;
    }

    public void run() {
        boolean z = true;
        if (this.b.e.g != this.b.a) {
            this.b.e.g = this.b.a;
            this.b.e.h = this.a;
            mz mzVar = this.b.e;
            boolean z2 = this.b.b != null && this.b.b.size() > 0;
            mzVar.f = z2;
            mz mzVar2 = this.b.e;
            if (this.b.c == null || this.b.c.size() <= 0) {
                z = false;
            }
            mzVar2.a = z;
            t.b(this.b.d);
        }
    }
}
