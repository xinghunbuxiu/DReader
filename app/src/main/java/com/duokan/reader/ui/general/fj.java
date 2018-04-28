package com.duokan.reader.ui.general;

class fj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fs f7227a;
    /* renamed from: b */
    final /* synthetic */ fs f7228b;
    /* renamed from: c */
    final /* synthetic */ Runnable f7229c;
    /* renamed from: d */
    final /* synthetic */ PagesController f7230d;

    fj(PagesController pagesController, fs fsVar, fs fsVar2, Runnable runnable) {
        this.f7230d = pagesController;
        this.f7227a = fsVar;
        this.f7228b = fsVar2;
        this.f7229c = runnable;
    }

    public void run() {
        this.f7230d.activate(this.f7227a);
        if (this.f7228b != null) {
            this.f7230d.deactivate(this.f7228b);
        }
        this.f7230d.mo1971a(this.f7230d.f6184b.size());
        if (this.f7229c != null) {
            this.f7229c.run();
        }
    }
}
