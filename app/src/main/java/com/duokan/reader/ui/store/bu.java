package com.duokan.reader.ui.store;

class bu implements Runnable {
    final /* synthetic */ br a;

    bu(br brVar) {
        this.a = brVar;
    }

    public void run() {
        if (this.a.c() < 0 && this.a.b.size() > 0) {
            this.a.a(0, false);
        }
    }
}
