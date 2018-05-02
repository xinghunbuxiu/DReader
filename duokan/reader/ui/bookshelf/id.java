package com.duokan.reader.ui.bookshelf;

class id implements Runnable {
    final /* synthetic */ ic a;

    id(ic icVar) {
        this.a = icVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
