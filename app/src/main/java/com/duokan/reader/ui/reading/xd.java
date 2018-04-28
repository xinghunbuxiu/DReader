package com.duokan.reader.ui.reading;

class xd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ wy f11139a;

    xd(wy wyVar) {
        this.f11139a = wyVar;
    }

    public void run() {
        this.f11139a.m13643l();
        if (this.f11139a.f9704g != null) {
            this.f11139a.f9704g.recycle();
            this.f11139a.f9704g = null;
        }
        this.f11139a.f9705h = null;
        this.f11139a.invalidate();
    }
}
