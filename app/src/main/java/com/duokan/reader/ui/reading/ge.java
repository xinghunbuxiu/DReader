package com.duokan.reader.ui.reading;

class ge implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10227a;
    /* renamed from: b */
    final /* synthetic */ gd f10228b;

    ge(gd gdVar, Runnable runnable) {
        this.f10228b = gdVar;
        this.f10227a = runnable;
    }

    public void run() {
        this.f10228b.m1352a((float) (this.f10228b.f10222b != null ? this.f10228b.f10222b.x : this.f10228b.f10223c.getWidth() / 2), (float) (this.f10228b.f10222b != null ? this.f10228b.f10222b.y : this.f10228b.f10223c.getHeight() / 2), this.f10228b.getContentStaticScale(), 0.0f, this.f10227a, this.f10227a);
    }
}
