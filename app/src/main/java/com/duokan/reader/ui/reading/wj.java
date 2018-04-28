package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.hq;

class wj implements hq {
    /* renamed from: a */
    final /* synthetic */ wd f11113a;

    wj(wd wdVar) {
        this.f11113a = wdVar;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        switch (i) {
            case 0:
                this.f11113a.f11102a.ae().m12491d(120000);
                this.f11113a.f11102a.ae().m12463X();
                this.f11113a.m15054e();
                return;
            case 2:
                this.f11113a.f11102a.ae().m12491d(600000);
                this.f11113a.f11102a.ae().m12463X();
                this.f11113a.m15054e();
                return;
            case 3:
                this.f11113a.f11102a.ae().m12491d(Integer.MAX_VALUE);
                this.f11113a.f11102a.ae().m12463X();
                this.f11113a.m15054e();
                return;
            default:
                this.f11113a.f11102a.ae().m12491d(300000);
                this.f11113a.f11102a.ae().m12463X();
                this.f11113a.m15054e();
                return;
        }
    }
}
