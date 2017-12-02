package com.duokan.reader.ui.personal;

import com.duokan.core.sys.t;

import java.util.ArrayList;

class fi implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ fg b;

    fi(fg fgVar, ArrayList arrayList) {
        this.b = fgVar;
        this.a = arrayList;
    }

    public void run() {
        boolean z = true;
        if (this.b.e.g != this.b.a) {
            this.b.e.g = this.b.a;
            this.b.e.h = this.a;
            fd fdVar = this.b.e;
            boolean z2 = this.b.b != null && this.b.b.size() > 0;
            fdVar.f = z2;
            fd fdVar2 = this.b.e;
            if (this.b.c == null || this.b.c.size() <= 0) {
                z = false;
            }
            fdVar2.a = z;
            t.b(this.b.d);
        }
    }
}
