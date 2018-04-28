package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.reader.common.p037c.C0559f;
import java.util.Collections;
import java.util.List;

class aah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aag f9329a;

    aah(aag aag) {
        this.f9329a = aag;
    }

    public void run() {
        for (String str : (List) UThread.m1035a(new aai(this))) {
            if (this.f9329a.f9327b.mo1041v(str) || !((Boolean) UThread.m1035a(new aaj(this, str))).booleanValue()) {
                for (String str2 : C0559f.m2476b().m2485d() ? this.f9329a.f9327b.mo1042w(str2) : Collections.emptyList()) {
                    if (!this.f9329a.f9327b.mo1043x(str2) && ((Boolean) UThread.m1035a(new aal(this, str2))).booleanValue()) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        this.f9329a.f9328c.f9312b = false;
    }
}
