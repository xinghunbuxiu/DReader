package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import java.util.ArrayList;

class fw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ArrayList f8572a;
    /* renamed from: b */
    final /* synthetic */ fu f8573b;

    fw(fu fuVar, ArrayList arrayList) {
        this.f8573b = fuVar;
        this.f8572a = arrayList;
    }

    public void run() {
        boolean z = true;
        if (this.f8573b.f8569e.f8559g != this.f8573b.f8565a) {
            this.f8573b.f8569e.f8559g = this.f8573b.f8565a;
            this.f8573b.f8569e.f8560h = this.f8572a;
            fr frVar = this.f8573b.f8569e;
            boolean z2 = this.f8573b.f8566b != null && this.f8573b.f8566b.size() > 0;
            frVar.f8558f = z2;
            fr frVar2 = this.f8573b.f8569e;
            if (this.f8573b.f8567c == null || this.f8573b.f8567c.size() <= 0) {
                z = false;
            }
            frVar2.f8557a = z;
            UThread.post(this.f8573b.f8568d);
        }
    }
}
