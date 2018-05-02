package com.duokan.reader.ui.bookshelf;

class fd implements Runnable {
    final /* synthetic */ fc a;

    fd(fc fcVar) {
        this.a = fcVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
