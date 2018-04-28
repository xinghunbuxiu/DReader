package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.hq;

class wg implements hq {
    /* renamed from: a */
    final /* synthetic */ wd f11110a;

    wg(wd wdVar) {
        this.f11110a = wdVar;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        switch (i) {
            case 1:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.THREE_DIMEN);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
            case 2:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.HSCROLL);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
            case 3:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.VSCROLL);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
            case 4:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.FADE_IN);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
            case 5:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.NONE);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
            default:
                this.f11110a.f11102a.ae().m12469a(PageAnimationMode.OVERLAP);
                this.f11110a.f11102a.ae().m12463X();
                this.f11110a.m15054e();
                return;
        }
    }
}
