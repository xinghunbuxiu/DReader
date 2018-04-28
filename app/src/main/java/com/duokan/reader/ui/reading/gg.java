package com.duokan.reader.ui.reading;

class gg implements Runnable {
    /* renamed from: a */
    final /* synthetic */ float f10235a;
    /* renamed from: b */
    final /* synthetic */ gf f10236b;

    gg(gf gfVar, float f) {
        this.f10236b = gfVar;
        this.f10235a = f;
    }

    public void run() {
        this.f10236b.f10234f.setMinZoomFactor(this.f10235a);
    }
}
