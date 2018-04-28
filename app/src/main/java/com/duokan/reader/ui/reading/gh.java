package com.duokan.reader.ui.reading;

import android.graphics.Point;

class gh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f10237a;
    /* renamed from: b */
    final /* synthetic */ gd f10238b;

    gh(gd gdVar, boolean z) {
        this.f10238b = gdVar;
        this.f10237a = z;
    }

    public void run() {
        Point contentStaticCenter = this.f10238b.getContentStaticCenter();
        this.f10238b.setMinZoomFactor(this.f10238b.getContentStaticScale());
        if (this.f10237a) {
            this.f10238b.m1360b((float) contentStaticCenter.x, (float) contentStaticCenter.y, this.f10238b.getContentStaticScale(), null, null);
        } else {
            this.f10238b.m1357b((float) contentStaticCenter.x, (float) contentStaticCenter.y, this.f10238b.getContentStaticScale());
        }
    }
}
