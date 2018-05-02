package com.duokan.reader.ui.general;

class fp implements Runnable {
    final /* synthetic */ fy a;
    final /* synthetic */ fy b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ PagesController d;

    fp(PagesController pagesController, fy fyVar, fy fyVar2, Runnable runnable) {
        this.d = pagesController;
        this.a = fyVar;
        this.b = fyVar2;
        this.c = runnable;
    }

    public void run() {
        this.d.activate(this.a);
        if (this.b != null) {
            this.d.deactivate(this.b);
        }
        this.d.a(this.d.b.size());
        if (this.c != null) {
            this.c.run();
        }
    }
}
