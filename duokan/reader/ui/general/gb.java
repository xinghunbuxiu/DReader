package com.duokan.reader.ui.general;

class gb implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ PagesView b;

    gb(PagesView pagesView, Runnable runnable) {
        this.b = pagesView;
        this.a = runnable;
    }

    public void run() {
        if (this.b.m()) {
            this.a.run();
        } else {
            this.b.g.add(this.a);
        }
    }
}
