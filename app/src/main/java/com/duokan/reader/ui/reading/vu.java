package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.ib;

class vu implements ib {
    final /* synthetic */ vq a;

    vu(vq vqVar) {
        this.a = vqVar;
    }

    public void a(int i) {
        switch (i) {
            case 0:
                this.a.a.ae().a(AnnotationStyle.BUBBLE);
                this.a.a.ae().Y();
                this.a.e();
                return;
            default:
                this.a.a.ae().a(AnnotationStyle.PAPERTAPE);
                this.a.a.ae().Y();
                this.a.e();
                return;
        }
    }
}
