package com.duokan.reader.ui.bookshelf;

class fe implements Runnable {
    final /* synthetic */ fc a;

    fe(fc fcVar) {
        this.a = fcVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
