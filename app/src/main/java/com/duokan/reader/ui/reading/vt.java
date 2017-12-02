package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.ib;

class vt implements ib {
    final /* synthetic */ vq a;

    vt(vq vqVar) {
        this.a = vqVar;
    }

    public void a(int i) {
        switch (i) {
            case 1:
                this.a.a.ae().a(PageAnimationMode.THREE_DIMEN);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 2:
                this.a.a.ae().a(PageAnimationMode.HSCROLL);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 3:
                this.a.a.ae().a(PageAnimationMode.VSCROLL);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 4:
                this.a.a.ae().a(PageAnimationMode.FADE_IN);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 5:
                this.a.a.ae().a(PageAnimationMode.NONE);
                this.a.a.ae().Y();
                this.a.e();
                return;
            default:
                this.a.a.ae().a(PageAnimationMode.OVERLAP);
                this.a.a.ae().Y();
                this.a.e();
                return;
        }
    }
}
