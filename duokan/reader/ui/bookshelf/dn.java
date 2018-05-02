package com.duokan.reader.ui.bookshelf;

class dn implements Runnable {
    final /* synthetic */ dm a;

    dn(dm dmVar) {
        this.a = dmVar;
    }

    public void run() {
        this.a.a.a.pushPageSmoothly(new fc(this.a.a.getContext()), null);
    }
}
