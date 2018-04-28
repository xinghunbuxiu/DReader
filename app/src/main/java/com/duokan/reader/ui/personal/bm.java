package com.duokan.reader.ui.personal;

class bm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bl f8334a;

    bm(bl blVar) {
        this.f8334a = blVar;
    }

    public void run() {
        int contentHeight = this.f8334a.f8333c.f8320a.getContentHeight() - this.f8334a.f8333c.f8320a.getHeight();
        if (contentHeight > 0) {
            this.f8334a.f8333c.f8320a.scrollTo(0, contentHeight);
        }
    }
}
