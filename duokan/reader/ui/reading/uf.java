package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.duokan.y;

class uf implements Runnable {
    final /* synthetic */ ue a;

    uf(ue ueVar) {
        this.a = ueVar;
    }

    public void run() {
        String H = this.a.a.H();
        if (this.a.a.aj()) {
            H = new y(this.a.a.H()).a();
        }
        sh a = this.a.b.a;
        int i = this.a.a.aj() ? 4 : this.a.a.k() ? 2 : 1;
        a.a(H, i);
    }
}
