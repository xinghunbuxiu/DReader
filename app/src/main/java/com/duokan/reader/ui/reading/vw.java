package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.ib;

class vw implements ib {
    final /* synthetic */ vq a;

    vw(vq vqVar) {
        this.a = vqVar;
    }

    public void a(int i) {
        switch (i) {
            case 0:
                this.a.a.ae().d(120000);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 2:
                this.a.a.ae().d(600000);
                this.a.a.ae().Y();
                this.a.e();
                return;
            case 3:
                this.a.a.ae().d(Integer.MAX_VALUE);
                this.a.a.ae().Y();
                this.a.e();
                return;
            default:
                this.a.a.ae().d(300000);
                this.a.a.ae().Y();
                this.a.e();
                return;
        }
    }
}
