package com.duokan.reader.ui.personal;

class be implements Runnable {
    final /* synthetic */ bd a;

    be(bd bdVar) {
        this.a = bdVar;
    }

    public void run() {
        int contentHeight = this.a.c.getContentHeight() - this.a.c.getHeight();
        if (contentHeight > 0) {
            this.a.c.scrollTo(0, contentHeight);
        }
    }
}
