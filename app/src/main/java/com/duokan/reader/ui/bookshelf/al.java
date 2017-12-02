package com.duokan.reader.ui.bookshelf;

class al implements Runnable {
    final /* synthetic */ ai a;

    al(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        this.a.requestDetach();
    }
}
