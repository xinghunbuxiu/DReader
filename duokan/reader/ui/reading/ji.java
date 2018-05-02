package com.duokan.reader.ui.reading;

class ji implements Runnable {
    final /* synthetic */ jh a;

    ji(jh jhVar) {
        this.a = jhVar;
    }

    public void run() {
        if (this.a.b.f) {
            this.a.b.i.a(true);
            this.a.b.setVisibility(0);
            return;
        }
        this.a.b.i.a(false);
        this.a.b.setVisibility(8);
        if (this.a.b.c.f != null) {
            this.a.b.c.f.run();
        }
    }
}
