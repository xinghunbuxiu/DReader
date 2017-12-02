package com.duokan.reader.ui.bookshelf;

class gz implements Runnable {
    final /* synthetic */ gx a;

    gz(gx gxVar) {
        this.a = gxVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
