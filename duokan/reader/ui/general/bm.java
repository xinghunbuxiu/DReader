package com.duokan.reader.ui.general;

class bm implements Runnable {
    final /* synthetic */ DkWebListView a;

    bm(DkWebListView dkWebListView) {
        this.a = dkWebListView;
    }

    public void run() {
        this.a.a.c();
    }
}
