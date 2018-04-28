package com.duokan.reader.ui.bookshelf;

class di implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f6335a;
    /* renamed from: b */
    final /* synthetic */ int f6336b;
    /* renamed from: c */
    final /* synthetic */ dh f6337c;

    di(dh dhVar, boolean z, int i) {
        this.f6337c = dhVar;
        this.f6335a = z;
        this.f6336b = i;
    }

    public void run() {
        if (this.f6335a) {
            this.f6337c.f6334d.f6070s.start();
        } else {
            this.f6337c.f6334d.f6070s.stop();
        }
        this.f6337c.f6334d.f6070s.setLevel(this.f6336b);
        this.f6337c.f6334d.invalidate();
    }
}
