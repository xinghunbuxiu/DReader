package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import java.util.ArrayList;

class ns implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ArrayList f9016a;
    /* renamed from: b */
    final /* synthetic */ nq f9017b;

    ns(nq nqVar, ArrayList arrayList) {
        this.f9017b = nqVar;
        this.f9016a = arrayList;
    }

    public void run() {
        boolean z = true;
        if (this.f9017b.f9014e.f9004g != this.f9017b.f9010a) {
            this.f9017b.f9014e.f9004g = this.f9017b.f9010a;
            this.f9017b.f9014e.f9005h = this.f9016a;
            nn nnVar = this.f9017b.f9014e;
            boolean z2 = this.f9017b.f9011b != null && this.f9017b.f9011b.size() > 0;
            nnVar.f9003f = z2;
            nn nnVar2 = this.f9017b.f9014e;
            if (this.f9017b.f9012c == null || this.f9017b.f9012c.size() <= 0) {
                z = false;
            }
            nnVar2.f9002a = z;
            UThread.post(this.f9017b.f9013d);
        }
    }
}
