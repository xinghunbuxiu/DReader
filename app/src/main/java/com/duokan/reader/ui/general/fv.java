package com.duokan.reader.ui.general;

class fv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f7265a;
    /* renamed from: b */
    final /* synthetic */ PagesView f7266b;

    fv(PagesView pagesView, Runnable runnable) {
        this.f7266b = pagesView;
        this.f7265a = runnable;
    }

    public void run() {
        if (this.f7266b.m10025m()) {
            this.f7265a.run();
        } else {
            this.f7266b.f6827g.add(this.f7265a);
        }
    }
}
