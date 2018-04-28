package com.duokan.reader.ui.personal;

class ax implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aw f8290a;

    ax(aw awVar) {
        this.f8290a = awVar;
    }

    public void run() {
        int contentHeight = this.f8290a.f8288c.getContentHeight() - this.f8290a.f8288c.getHeight();
        if (contentHeight > 0) {
            this.f8290a.f8288c.scrollTo(0, contentHeight);
        }
    }
}
