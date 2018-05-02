package com.duokan.reader.ui.reading;

import android.graphics.Point;

class gc implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ fy b;

    gc(fy fyVar, boolean z) {
        this.b = fyVar;
        this.a = z;
    }

    public void run() {
        Point contentStaticCenter = this.b.getContentStaticCenter();
        this.b.setMinZoomFactor(this.b.getContentStaticScale());
        if (this.a) {
            this.b.b((float) contentStaticCenter.x, (float) contentStaticCenter.y, this.b.getContentStaticScale(), null, null);
        } else {
            this.b.b((float) contentStaticCenter.x, (float) contentStaticCenter.y, this.b.getContentStaticScale());
        }
    }
}
