package com.duokan.reader.ui.personal;

class bt implements Runnable {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    public void run() {
        int contentHeight = this.a.c.a.getContentHeight() - this.a.c.a.getHeight();
        if (contentHeight > 0) {
            this.a.c.a.scrollTo(0, contentHeight);
        }
    }
}
