package com.duokan.reader.ui.reading;

class js implements Runnable {
    /* renamed from: a */
    final /* synthetic */ jr f10467a;

    js(jr jrVar) {
        this.f10467a = jrVar;
    }

    public void run() {
        if (this.f10467a.f10466b.f10460f) {
            this.f10467a.f10466b.f10463i.m2043a(true);
            this.f10467a.f10466b.setVisibility(0);
            return;
        }
        this.f10467a.f10466b.f10463i.m2043a(false);
        this.f10467a.f10466b.setVisibility(8);
        if (this.f10467a.f10466b.f10457c.f10450f != null) {
            this.f10467a.f10466b.f10457c.f10450f.run();
        }
    }
}
